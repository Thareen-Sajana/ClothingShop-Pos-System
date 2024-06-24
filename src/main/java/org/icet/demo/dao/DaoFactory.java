package org.icet.demo.dao;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dao.custom.impl.*;
import org.icet.demo.util.DaoType;

public class DaoFactory {

    private static DaoFactory instance;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance!=null?instance:(instance= new DaoFactory());
    }

    public <T extends SuperDao> T getDao(DaoType type){

        switch (type){
            case USER:return (T) new UserDaoImpl();
            case AUTHENTICATE:return (T) new AuthenticateDaoImpl();
            case SUPPLIER:return (T) new SupplierDaoImpl();
            case PRODUCT:return (T) new ProductDaoImpl();
            case MEASURMENT:return (T) new MeasurmentDaoImpl();
            case ORDER:return (T) new OrderDaoImpl();
            case ORDERDETAIL:return (T) new OrderDetailsDaoImpl();
        }
        return null;
    }
}
