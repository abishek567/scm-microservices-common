package scmmicroservices.common.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scmmicroservices.common.exception.CustomException;
import scmmicroservices.common.response.Response;
import scmmicroservices.common.response.ResponseFactory;

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
