package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icet.demo.dao.custom.OrderDetailsDao;
import org.icet.demo.entity.OrderDetailsEntity;
import org.icet.demo.entity.OrderEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Override
    public boolean save(OrderDetailsEntity dto) {
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
    public boolean delete(OrderDetailsEntity dto) {
        return false;
    }

    @Override
    public boolean update(OrderDetailsEntity dto) {
        return false;
    }

    @Override
    public List<OrderDetailsEntity> retriveAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<OrderDetailsEntity> orderDetailsData;
        try {
            tx = session.beginTransaction();
            orderDetailsData = session.createQuery("SELECT a FROM OrderDetailsEntity a", OrderDetailsEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return orderDetailsData;
    }
}
