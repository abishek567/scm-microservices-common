package scmmicroservices.common.dtos.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {
    private String address;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String landline;
}
