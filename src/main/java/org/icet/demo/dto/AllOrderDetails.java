package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AllOrderDetails {

    String ordId;
    String userId;
    String proId;
    Integer qty;
    String customerName;
    String time;
    String date;
    String paymentType;
    Double discount;
    Double total;
    String size;
    String productName;
}
