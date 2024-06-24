package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icet.demo.dao.custom.MeasurmentDao;
import org.icet.demo.entity.MeasurmentEntity;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class MeasurmentDaoImpl implements MeasurmentDao {

    @Override
    public boolean save(MeasurmentEntity dto) {
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
    public boolean delete(MeasurmentEntity dto) {
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
    public boolean update(MeasurmentEntity dto) {
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
    public List<MeasurmentEntity> retriveAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<MeasurmentEntity> measurmentData;
        try {
            tx = session.beginTransaction();
            measurmentData = session.createQuery("SELECT a FROM MeasurmentEntity a", MeasurmentEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return measurmentData;
    }
}
