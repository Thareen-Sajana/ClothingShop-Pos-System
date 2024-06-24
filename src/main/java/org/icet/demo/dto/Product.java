package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private String proId;
    private String name;
    private String category;
    private Double price;
    private String supId;
}
