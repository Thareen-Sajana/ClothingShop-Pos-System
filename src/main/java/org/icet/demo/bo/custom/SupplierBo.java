package org.icet.demo.bo.custom;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dto.Supplier;
import org.icet.demo.dto.User;
import org.icet.demo.dto.ViewSupplier;
import org.icet.demo.entity.SupplierEntity;
import org.icet.demo.entity.UserEntity;

import java.util.List;

public interface SupplierBo extends SuperBo {

    String generateId();

    List<SupplierEntity> getAllSuppliers();

    List<ViewSupplier> viewSuppliers();

    boolean saveSupplier(Supplier dto);

    boolean isSupplierAvailable(Supplier sup);

    Supplier findSupplierById(String supId);

    boolean updateSupplier(Supplier supplier);

    List<String> getSupplierId();

    boolean delete(Supplier supplier);
}
