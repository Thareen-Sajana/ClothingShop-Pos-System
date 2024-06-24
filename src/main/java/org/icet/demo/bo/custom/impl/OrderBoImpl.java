package org.icet.demo.bo.custom.impl;

import org.icet.demo.bo.custom.OrderBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.OrderDao;
import org.icet.demo.dto.Order;
import org.icet.demo.dto.User;
import org.icet.demo.entity.OrderEntity;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.DaoType;

import java.util.List;

public class OrderBoImpl implements OrderBo {

    private OrderDao orderDao = DaoFactory.getInstance().getDao(DaoType.ORDER);
    @Override
    public boolean saveOrder(Order dto) {

        OrderEntity order = new OrderEntity();
        order.setOrId(dto.getOrId());
        order.setUserId(dto.getUserId());
        return orderDao.save(order);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderDao.retriveAll();
    }

    @Override
    public String generateOrderId() {
        List<OrderEntity> orders = getAllOrders();

        String newNumericPart = "00001";
        String prefix = "OR";

        int count = 0;
        for (OrderEntity order: orders){

            String id = order.getOrId();

            prefix = id.substring(0, 2);

            // Extract the numeric part
            String numericPart = id.substring(2);

            // Convert numeric part to integer
            int number = Integer.parseInt(numericPart);

            // Increment the number by 1
            number++;

            // Format the new number back to the same number of digits
            newNumericPart = String.format("%05d", number);

            count++;
        }
        if(count==0){
            return "OR00001";
        }else {
            // Return the new ID
            return prefix + newNumericPart;
        }
    }


}
