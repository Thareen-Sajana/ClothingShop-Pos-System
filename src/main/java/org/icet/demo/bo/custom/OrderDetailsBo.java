package org.icet.demo.bo.custom;

import javafx.collections.ObservableList;
import org.icet.demo.bo.SuperBo;
import org.icet.demo.dto.Order;
import org.icet.demo.dto.OrderDetail;
import org.icet.demo.dto.ViewOrdersSection;
import org.icet.demo.entity.OrderDetailsEntity;
import org.icet.demo.entity.UserEntity;

import java.util.List;

public interface OrderDetailsBo extends SuperBo {

    boolean saveOrderDetail(OrderDetail dto);
    List<OrderDetailsEntity> getAlOrderDetails();

    ObservableList<ViewOrdersSection> gellAllOrdersForView();
}
