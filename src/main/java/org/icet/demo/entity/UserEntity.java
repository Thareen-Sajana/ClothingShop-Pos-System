package org.icet.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "User")
public class UserEntity {

    @Id
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
