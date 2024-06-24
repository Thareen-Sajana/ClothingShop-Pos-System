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
@Table( name = "Supplier")
public class SupplierEntity {

    @Id
    private String supId;

    private String name;
    private String email;
    private String company;

}
