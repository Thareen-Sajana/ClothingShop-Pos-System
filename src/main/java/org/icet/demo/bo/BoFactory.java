package org.icet.demo.bo;

import org.icet.demo.bo.custom.AuthenticateBo;
import org.icet.demo.bo.custom.impl.*;
import org.icet.demo.util.BoType;

public class BoFactory {

    private static BoFactory instance;
    private BoFactory(){}
    public static BoFactory getInstance(){
        if (instance==null){
            instance = new BoFactory();
        }
        return instance;
    }

    public <T extends SuperBo> T getBo(BoType type){

        switch (type){
            case USER:return (T) new UserBoImpl();
            case AUTHENTICATE: return (T) new AuthenticateBoImpl();
            case SUPPLIER: return (T) new SupplierBoImpl();
            case PRODUCT: return (T) new ProductBoImpl();
            case MEASURMENT:return (T) new MeasurmentBoImpl();
            case ORDER:return (T) new OrderBoImpl();
            case ORDERDETAIL:return (T) new OrderDetailsBoimpl();
        }
        return null;
    }
}
