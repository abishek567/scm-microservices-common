package scm.common.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response<T> {

    private ResponseHeader responseHeader;
    private T responseBody;
    public Response(ResponseHeader responseHeader, T responseBody) {
        this.responseHeader = responseHeader;
        this.responseBody = responseBody;
    }

}
