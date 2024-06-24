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
@Table( name = "CustomerOrder")
public class OrderEntity {

    @Id
    private String orId;

    private String userId;

}
