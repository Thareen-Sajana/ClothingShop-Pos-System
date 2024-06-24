package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icet.demo.dao.custom.OrderDao;
import org.icet.demo.entity.OrderEntity;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderEntity dto) {
        boolean isSaved = false;

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(dto);
            tx.commit();
            isSaved = true;
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return isSaved;
    }

    @Override
    public boolean delete(OrderEntity dto) {
        return false;
    }

    @Override
    public boolean update(OrderEntity dto) {
        return false;
    }

    @Override
    public List<OrderEntity> retriveAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<OrderEntity> orderData;
        try {
            tx = session.beginTransaction();
            orderData = session.createQuery("SELECT a FROM OrderEntity a", OrderEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return orderData;
    }
}
