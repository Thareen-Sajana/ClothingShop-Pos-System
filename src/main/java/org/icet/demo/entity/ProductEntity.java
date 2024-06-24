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
@Table( name = "Product")
public class ProductEntity {

    @Id
    private String proId;

    private String name;
    private String category;
    private Double price;
    private String supId;

}
