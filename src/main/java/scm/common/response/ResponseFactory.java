package scm.common.response;


import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ResponseFactory {

    public static Response<Object> createErrorResponse(HttpStatus status, Exception exception) {
        ResponseHeader responseHeader = new ResponseHeader(Instant.now(), status, exception);

        return new Response<>(responseHeader, null);
    }

    public static Response<Object> createOkResponse(Object body) {
        ResponseHeader responseHeader = new ResponseHeader(Instant.now(), HttpStatus.OK, null);

        return new Response<>(responseHeader, body);
    }

}
