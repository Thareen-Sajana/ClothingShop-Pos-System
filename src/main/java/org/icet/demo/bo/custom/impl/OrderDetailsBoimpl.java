package org.icet.demo.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.icet.demo.bo.custom.OrderDetailsBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.OrderDao;
import org.icet.demo.dao.custom.OrderDetailsDao;
import org.icet.demo.dao.custom.ProductDao;
import org.icet.demo.dto.OrderDetail;
import org.icet.demo.dto.ViewOrdersSection;
import org.icet.demo.entity.OrderDetailsEntity;
import org.icet.demo.entity.OrderEntity;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.util.DaoType;

import java.util.List;

public class OrderDetailsBoimpl implements OrderDetailsBo {

    private OrderDetailsDao orderDetailsDao = DaoFactory.getInstance().getDao(DaoType.ORDERDETAIL);
    private ProductDao productDao = DaoFactory.getInstance().getDao(DaoType.PRODUCT);

    @Override
    public boolean saveOrderDetail(OrderDetail dto) {

        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setCustomerName(dto.getCustomerName());
        orderDetailsEntity.setTime(dto.getTime());
        orderDetailsEntity.setDate(dto.getDate());
        orderDetailsEntity.setPaymentType(dto.getPaymentType());
        orderDetailsEntity.setDiscount(dto.getDiscount());
        orderDetailsEntity.setTotal(dto.getTotal());
        orderDetailsEntity.setOrId(dto.getOrId());
        orderDetailsEntity.setSize(dto.getSize());
        orderDetailsEntity.setQty(dto.getQty());
        orderDetailsEntity.setProId(dto.getProId());
        return orderDetailsDao.save(orderDetailsEntity);
    }

    @Override
    public List<OrderDetailsEntity> getAlOrderDetails() {
        return orderDetailsDao.retriveAll();
    }

    @Override
    public ObservableList<ViewOrdersSection> gellAllOrdersForView() {

        List<OrderDetailsEntity> orderDetails = getAlOrderDetails();
        List<ProductEntity> products = productDao.retriveAll();

        ObservableList<ViewOrdersSection> viewOrders =FXCollections.observableArrayList();

        for (OrderDetailsEntity orderDetailsEntity : orderDetails){
            for (ProductEntity product : products){

                if(orderDetailsEntity.getProId().equals(product.getProId())){

                    ViewOrdersSection order = new ViewOrdersSection();
                    order.setOrId(orderDetailsEntity.getOrId());
                    order.setProductName(product.getName());
                    order.setCustomerName(orderDetailsEntity.getCustomerName());
                    order.setTime(orderDetailsEntity.getTime());
                    order.setDate(orderDetailsEntity.getDate());
                    order.setDiscount(orderDetailsEntity.getDiscount());
                    order.setQty(orderDetailsEntity.getQty());
                    order.setTotal(orderDetailsEntity.getTotal());

                    viewOrders.add(order);
                    break;
                }
            }
        }
        return viewOrders;
    }
}
