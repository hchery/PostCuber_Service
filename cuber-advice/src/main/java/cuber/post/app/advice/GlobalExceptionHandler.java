package cuber.post.app.advice;

import cuber.post.app.sdk.CuberException;
import cuber.post.app.sdk.ErrorCode;
import cuber.post.app.sdk.http.ApiBody;
import cuber.post.app.sdk.i18n.I18nContext;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private ContextClient contextClient;

    @Resource
    private I18nContext i18nContext;

    @ExceptionHandler(CuberException.class)
    public ApiBody cuberException(CuberException ex) {
        contextClient.setThrown(ex);
        return new ApiBody(
            ex.getCode(),
            i18nContext.read(ex.getDescI18nKey())
        );
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiBody requestMethodNotAllowed(MethodNotAllowedException ex) {
        return makeBody(
            ex,
            ErrorCode.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiBody httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return makeBody(
            ex,
            ErrorCode.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiBody httpMessageNotReadable(HttpMessageNotReadableException ex) {
        return makeBody(
            ex,
            ErrorCode.BAD_REQUEST
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiBody noResourceFound(NoResourceFoundException ex) {
        return makeBody(
            ex,
            ErrorCode.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ApiBody allException(Exception ex) {
        return makeBody(
            ex,
            ErrorCode.SERVER_ERROR
        );
    }

    private ApiBody makeBody(Exception ex, ErrorCode code) {
        CuberException thrown = code.errors(ex.getMessage(), ex);
        return cuberException(thrown);
    }
}
