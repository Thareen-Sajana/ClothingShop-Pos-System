package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthenticationDetails {

    private Integer authenticationId;
    private String password;
    private String saltValue;
    private String userId;
    private String email;
    private String role;
}
