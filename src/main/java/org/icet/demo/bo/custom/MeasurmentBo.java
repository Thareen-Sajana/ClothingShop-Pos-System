package org.icet.demo.bo.custom;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dao.SuperDao;
import org.icet.demo.dto.Measurment;
import org.icet.demo.dto.Supplier;
import org.icet.demo.entity.MeasurmentEntity;
import org.icet.demo.entity.ProductEntity;

import java.util.List;

public interface MeasurmentBo extends SuperBo {

    boolean saveMeasurements(Measurment dto);

    List<MeasurmentEntity> getAllMeasurmentData();

    MeasurmentEntity getMeasurmentByProductId(String proId);

    boolean updateMeasurment(MeasurmentEntity measurment);

    boolean deleteMeasurment(Measurment measurment);
}
