package org.icet.demo.bo.custom.impl;


import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.ProductDao;
import org.icet.demo.dao.custom.SupplierDao;
import org.icet.demo.dto.Supplier;
import org.icet.demo.dto.ViewSupplier;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.entity.SupplierEntity;

import java.util.ArrayList;
import java.util.List;

import static org.icet.demo.util.DaoType.PRODUCT;
import static org.icet.demo.util.DaoType.SUPPLIER;

public class SupplierBoImpl implements SupplierBo {

    private SupplierDao supplierDao = DaoFactory.getInstance().getDao(SUPPLIER);
    private ProductDao productDao = DaoFactory.getInstance().getDao(PRODUCT);
    @Override
    public String generateId() {

        List<SupplierEntity> suppliers = getAllSuppliers();

        String newNumericPart = "00001";
        String prefix = "S";

        int count = 0;
        for (SupplierEntity supplier: suppliers){
            String id = supplier.getSupId();

            prefix = id.substring(0, 1);

            // Extract the numeric part
            String numericPart = id.substring(1);

            // Convert numeric part to integer
            int number = Integer.parseInt(numericPart);

            // Increment the number by 1
            number++;

            // Format the new number back to the same number of digits
            newNumericPart = String.format("%05d", number);

            count++;
        }
        if(count==0){
            return "S00001";
        }else {
            // Return the new ID
            return prefix + newNumericPart;
        }
    }

    @Override
    public List<SupplierEntity> getAllSuppliers() {
        return supplierDao.retriveAll();
    }

    @Override
    public List<ViewSupplier> viewSuppliers() {

        List<ProductEntity> products = productDao.retriveAll();
        List<SupplierEntity> suppliers = getAllSuppliers();

        List<ViewSupplier> viewSuppliers = new ArrayList<>();

        for (SupplierEntity supplier : suppliers){
            for (ProductEntity product : products){

                if(supplier.getSupId().equals(product.getSupId())){

                    ViewSupplier viewSupplier = new ViewSupplier();

                    viewSupplier.setSupId(supplier.getSupId());
                    viewSupplier.setName(supplier.getName());
                    viewSupplier.setCompany(supplier.getCompany());
                    viewSupplier.setProductName(product.getName());
                    viewSupplier.setEmail(supplier.getEmail());

                    viewSuppliers.add(viewSupplier);
                }
            }
        }
        return viewSuppliers;
    }

    @Override
    public boolean saveSupplier(Supplier dto) {

        SupplierEntity supplierEntity = new SupplierEntity();

        supplierEntity.setSupId(dto.getSupId());
        supplierEntity.setName(dto.getName());
        supplierEntity.setEmail(dto.getEmail());
        supplierEntity.setCompany(dto.getCompany());

        return supplierDao.save(supplierEntity);
    }

    @Override
    public boolean isSupplierAvailable(Supplier sup) {

        List<SupplierEntity> suppliers = getAllSuppliers();

        for(SupplierEntity supplier : suppliers){

            if(sup.getName().equals(supplier.getName()) &&
            sup.getCompany().equals(supplier.getCompany()) &&
            sup.getEmail().equals(supplier.getEmail())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Supplier findSupplierById(String supId) {

        List<SupplierEntity> suppliers = getAllSuppliers();
        Supplier sup = new Supplier();

        for(SupplierEntity supplier : suppliers){
            if(supplier.getSupId().equals(supId)){

                sup.setSupId(supplier.getSupId());
                sup.setName(supplier.getName());
                sup.setCompany(supplier.getCompany());
                sup.setEmail(supplier.getEmail());
                return sup;
            }
        }
        return null;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {

        SupplierEntity supplierEntity = new SupplierEntity();

        supplierEntity.setSupId(supplier.getSupId());
        supplierEntity.setName(supplier.getName());
        supplierEntity.setEmail(supplier.getEmail());
        supplierEntity.setCompany(supplier.getCompany());

        return supplierDao.update(supplierEntity);
    }

    @Override
    public List<String> getSupplierId() {

        List<SupplierEntity> suppliers = getAllSuppliers();
        List<String> supplierIds = new ArrayList<>();

        if(suppliers != null){
            for (SupplierEntity supplier : suppliers){
               supplierIds.add(supplier.getSupId());
            }
            return supplierIds;
        }
        return null;
    }

    @Override
    public boolean delete(Supplier supplier) {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setSupId(supplier.getSupId());
        supplierEntity.setName(supplier.getName());
        supplierEntity.setEmail(supplier.getEmail());
        supplierEntity.setCompany(supplier.getCompany());

        return supplierDao.delete(supplierEntity);
    }
}
