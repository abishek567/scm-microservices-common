package scm.common.dto;

import lombok.Data;

@Data
public class BaseDTO {
    private String message;
    private boolean isFailure;
}
