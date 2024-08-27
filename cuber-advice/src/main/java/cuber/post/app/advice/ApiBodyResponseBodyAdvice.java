package cuber.post.app.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import cuber.post.app.sdk.http.ApiBody;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;
import java.util.Set;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RestControllerAdvice
public class ApiBodyResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Set<Class<? extends HttpMessageConverter<?>>> SUPPORT_CONVERTERS = Set.of(
        StringHttpMessageConverter.class,
        MappingJackson2HttpMessageConverter.class
    );

    private static final Set<Integer> TRANSMISSION_STATUS = Set.of(
        HttpStatus.NOT_FOUND.value(),
        HttpStatus.METHOD_NOT_ALLOWED.value()
    );

    @Resource
    private ObjectMapper objectMapper;

    @SneakyThrows
    private String toJsonString(Object object) {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public boolean supports(
        @NonNull MethodParameter returnType,
        @NonNull Class<? extends HttpMessageConverter<?>> converterType
    ) {
        return SUPPORT_CONVERTERS.contains(converterType);
    }

    @Override
    public Object beforeBodyWrite(
        @Nullable Object body,
        @NonNull MethodParameter returnType,
        @NonNull MediaType selectedContentType,
        @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
        @NonNull ServerHttpRequest request,
        @NonNull ServerHttpResponse response
    ) {
        int responseStatus = readStatus(response);
        // 重定向不需要做处理
        // 一般重定向响应不会携带数据
        // 浏览器读取到重定向后就跳转了
        if (isRedirect(responseStatus)) {
            return body;
        }
        // 服务端响应了错误码
        // 要对部分客户端请求错误回传
        // 同时修正Spring默认返回的结构
        if (isError(responseStatus)) {
            if (!TRANSMISSION_STATUS.contains(responseStatus)) {
                response.setStatusCode(HttpStatus.OK);
            }
            if (body == null || body instanceof ApiBody) {
                return body;
            }
            @SuppressWarnings("unchecked")
            Map<String, Object> bodyMap = (Map<String, Object>) body;
            return new ApiBody(
                (int) bodyMap.get("status"),
                "%s %s".formatted(bodyMap.get("path"), bodyMap.get("error"))
            );
        }

        if (body instanceof ApiBody) {
            return body;
        }

        if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return toJsonString(new ApiBody(body));
        }

        return new ApiBody(body);
    }

    private static int readStatus(ServerHttpResponse response) {
        ServletServerHttpResponse servletServerHttpResponse = (ServletServerHttpResponse) response;
        return servletServerHttpResponse.getServletResponse().getStatus();
    }

    private static boolean isError(int status) {
        return switch (status / 100) {
            case 4, 5 -> true;
            default -> false;
        };
    }

    private static boolean isRedirect(int status) {
        return status / 3 == 100;
    }
}
