package org.icet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "OrderDetail")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailsId;

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
