package scmmicroservices.common.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {

    private ResponseHeader responseHeader;
    private T responseBody;

}
