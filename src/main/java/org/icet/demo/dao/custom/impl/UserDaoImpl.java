package org.icet.demo.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.icet.demo.dao.custom.UserDao;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(UserEntity dto) {
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
    public boolean delete(UserEntity dto) {

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
    public boolean update(UserEntity dto) {
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
    public List<UserEntity> retriveAll() {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        List<UserEntity> userData;
        try {
            tx = session.beginTransaction();
            userData = session.createQuery("SELECT a FROM UserEntity a", UserEntity.class).getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx!=null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return userData;
    }
}
