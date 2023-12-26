package scm.common.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scm.common.exception.CustomException;
import scm.common.response.Response;
import scm.common.response.ResponseFactory;

@RestControllerAdvice
public class CustomResponseExceptionAdvice {

    @ExceptionHandler(value = CustomException.class)
    public Response<Object> handleCustomException(CustomException exception) {
        return ResponseFactory.createErrorResponse(exception.getStatus(), exception);
    }

    @ExceptionHandler(value = Exception.class)
    public Response<Object> handleFatalException(Exception exception) {
        // TODO: log error and push to messaging queue
        return ResponseFactory.createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

}
