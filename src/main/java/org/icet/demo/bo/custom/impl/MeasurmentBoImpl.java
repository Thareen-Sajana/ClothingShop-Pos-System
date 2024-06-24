package org.icet.demo.bo.custom.impl;

import org.icet.demo.bo.custom.MeasurmentBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.MeasurmentDao;
import org.icet.demo.dto.Measurment;
import org.icet.demo.entity.MeasurmentEntity;
import org.icet.demo.util.DaoType;

import java.util.List;

public class MeasurmentBoImpl implements MeasurmentBo {

    MeasurmentDao measurmentDao = DaoFactory.getInstance().getDao(DaoType.MEASURMENT);

    @Override
    public boolean saveMeasurements(Measurment dto) {

        MeasurmentEntity measurment = new MeasurmentEntity();

        measurment.setProId(dto.getProId());
        measurment.setQty(dto.getQty());
        measurment.setSize(dto.getSize());

        return measurmentDao.save(measurment);
    }

    @Override
    public List<MeasurmentEntity> getAllMeasurmentData() {
        return measurmentDao.retriveAll();
    }

    @Override
    public MeasurmentEntity getMeasurmentByProductId(String proId) {

        List<MeasurmentEntity> measurmentEntities = getAllMeasurmentData();

        for (MeasurmentEntity measurment : measurmentEntities){
            if(measurment.getProId().equals(proId)){
                return measurment;
            }
        }
        return null;
    }

    @Override
    public boolean updateMeasurment(MeasurmentEntity measurment) {
        return measurmentDao.update(measurment);
    }

    @Override
    public boolean deleteMeasurment(Measurment measurment) {

        MeasurmentEntity measurment1 = new MeasurmentEntity();
        measurment1.setMeasurmentId(measurment.getMeasurmentId());
        return measurmentDao.delete(measurment1);
    }
}
