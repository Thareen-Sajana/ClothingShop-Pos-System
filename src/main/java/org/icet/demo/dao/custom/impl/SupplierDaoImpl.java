package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icet.demo.dao.custom.SupplierDao;
import org.icet.demo.entity.SupplierEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {

    @Override
    public boolean save(SupplierEntity dto) {
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
    public boolean delete(SupplierEntity dto) {

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
    public boolean update(SupplierEntity dto) {
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
    public List<SupplierEntity> retriveAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<SupplierEntity> supplierData;
        try {
            tx = session.beginTransaction();
            supplierData = session.createQuery("SELECT a FROM SupplierEntity a", SupplierEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return supplierData;
    }
}
