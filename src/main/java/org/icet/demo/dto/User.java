package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {

    private String userId;
    private String firstName;
    private String lastName;
    private String gender;
    private String role;
    private String position;
    private String contactNo;
    private String email;
    private String birthday;

}
