package org.icet.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ViewOrdersSection {

    String orId;
    String productName;
    String customerName;
    String time;
    String date;
    Double discount;
    Integer qty;
    Double total;
}
