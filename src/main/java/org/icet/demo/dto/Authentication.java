package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Authentication {

    private Integer authenticationId;
    private String password;
    private String saltValue;
    private String userId;

}
