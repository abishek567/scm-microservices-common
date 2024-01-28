package com.scm.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends BaseDTO implements Serializable {
    private String roleId;
    private String roleCode;
    private String roleName;
    private String roleDesc;
}