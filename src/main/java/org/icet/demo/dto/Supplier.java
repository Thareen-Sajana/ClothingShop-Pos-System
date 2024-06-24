package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Supplier {
    private String supId;
    private String name;
    private String email;
    private String company;
}
