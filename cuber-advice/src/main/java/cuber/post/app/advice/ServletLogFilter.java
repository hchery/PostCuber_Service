package cuber.post.app.advice;

import cuber.post.app.sdk.CuberAppArgs;
import cuber.post.app.sdk.CuberException;
import cuber.post.app.sdk.ErrorLevel;
import cuber.post.app.sdk.utils.MsTimer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Slf4j(topic = "servlet-log")
public class ServletLogFilter extends OncePerRequestFilter {

    private final CuberAppArgs args;
    private final ContextClient client;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain chain
    ) throws ServletException, IOException {
        MsTimer timer = MsTimer.now();
        try {
            chain.doFilter(request, response);
        } finally {
            lowWrite(timer);
        }
    }

    private void lowWrite(MsTimer timer) {
        CuberException thrown = client.getThrown();
        String text = logText(timer);
        Throwable ex = makeThrown(thrown);
        switch (logLevel(thrown)) {
            case DEBUG -> {
                if (log.isDebugEnabled()) {
                    log.debug(text, ex);
                }
            }
            case INFO -> log.info(text, ex);
            case WARN -> log.warn(text, ex);
            case ERROR -> log.error(text, ex);
        }
    }

    private String logText(MsTimer timer) {
        return "%s|%s|%dms|%s|%s".formatted(
            client.getMethod(),
            client.getPath(),
            timer.point(),
            client.getRemoteIp(),
            logResult(client.getThrown())
        );
    }

    private String logResult(CuberException ex) {
        if (ex == null) {
            return "200 -> OK";
        }
        String text = "%s -> %s".formatted(ex.getCode(), ex.getMessage());
        Throwable cause = ex.getCause();
        if (cause != null) {
            text = "%s (%s)".formatted(text, cause.getClass().getName());
        }
        return text;
    }

    private ErrorLevel logLevel(CuberException ex) {
        return ex == null ? ErrorLevel.INFO : ex.getLevel();
    }

    private Throwable makeThrown(CuberException ex) {
        // 非开发模式不打印异常栈
        if (!args.isDevMode()) {
            return null;
        }
        if (ex == null) {
            return null;
        }
        Throwable cause = ex.getCause();
        return cause == null ? ex : cause;
    }
}
