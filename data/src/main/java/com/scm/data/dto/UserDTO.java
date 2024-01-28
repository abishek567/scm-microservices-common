package com.scm.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO implements Serializable {
    private String userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private List<RoleDTO> roles;
    private AddressDTO address;
}
