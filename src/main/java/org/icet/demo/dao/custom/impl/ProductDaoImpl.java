package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icet.demo.dao.custom.ProductDao;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.entity.SupplierEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean save(ProductEntity dto) {
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
    public boolean delete(ProductEntity dto) {

        boolean isDeleted = false;

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(dto);
            tx.commit();
            isDeleted = true;

        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public boolean update(ProductEntity dto) {
        boolean isUpdate = false;

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(dto);
            tx.commit();
            isUpdate = true;
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return isUpdate;
    }

    @Override
    public List<ProductEntity> retriveAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<ProductEntity> productData;
        try {
            tx = session.beginTransaction();
            productData = session.createQuery("SELECT a FROM ProductEntity a", ProductEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return productData;
    }
}
