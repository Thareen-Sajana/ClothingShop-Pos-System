package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icet.demo.dao.custom.AuthenticateDao;
import org.icet.demo.entity.AuthenticationEntity;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class AuthenticateDaoImpl implements AuthenticateDao {
    @Override
    public boolean save(AuthenticationEntity dto) {

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
    public boolean delete(AuthenticationEntity dto) {
        boolean isDelete = false;

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(dto);
            tx.commit();
            isDelete = true;
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return isDelete;
    }

    @Override
    public boolean update(AuthenticationEntity dto) {
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
    public List<AuthenticationEntity> retriveAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<AuthenticationEntity> data;
        try {
            tx = session.beginTransaction();
            data = session.createQuery("SELECT a FROM AuthenticationEntity a", AuthenticationEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return data;
    }
}
