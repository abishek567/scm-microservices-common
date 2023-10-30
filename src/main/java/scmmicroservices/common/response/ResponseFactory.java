package scmmicroservices.common.response;


import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ResponseFactory {

    public static Response<Object> createErrorResponse(HttpStatus status, Exception exception) {
        ResponseHeader responseHeader = ResponseHeader.builder()
                .timestamp(Instant.now())
                .status(status)
                .error(exception)
                .build();

        return Response.builder()
                .responseHeader(responseHeader)
                .responseBody(null)
                .build();
    }

    public static Response<Object> createOkResponse(Object body) {
        ResponseHeader responseHeader = ResponseHeader.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.OK)
                .error(null)
                .build();

        return Response.builder()
                .responseHeader(responseHeader)
                .responseBody(body)
                .build();
    }

}
