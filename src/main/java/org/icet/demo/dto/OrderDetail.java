package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDetail {

    private String customerName;
    private String time;
    private String date;
    private String paymentType;
    private Double discount;
    private Double total;
    private String size;
    private String orId;
    private Integer qty;
    private String proId;
}
