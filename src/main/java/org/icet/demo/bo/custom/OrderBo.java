package org.icet.demo.bo.custom;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dto.Order;
import org.icet.demo.dto.User;
import org.icet.demo.entity.OrderEntity;
import org.icet.demo.entity.UserEntity;

import java.util.List;

public interface OrderBo extends SuperBo {

    boolean saveOrder(Order dto);

    List<OrderEntity> getAllOrders();

    String generateOrderId();
}
