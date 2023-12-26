package scm.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDTO extends BaseDTO implements Serializable {

    private String roleId;
    private String roleName;
    private String roleDesc;

}
