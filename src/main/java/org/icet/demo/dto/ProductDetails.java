package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDetails {

    private String proId;
    private String name;
    private String category;
    private String size;
    private Integer qty;
    private Double price;
    private String supId;
}
