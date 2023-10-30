package scmmicroservices.common.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class ResponseHeader {

    private Instant timestamp;
    private HttpStatus status;
    private Exception error;
//    private Exception exception;

}
