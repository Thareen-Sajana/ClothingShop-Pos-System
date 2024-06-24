package org.icet.demo.bo.custom.impl;

import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.SuperBo;
import org.icet.demo.bo.custom.MeasurmentBo;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.MeasurmentDao;
import org.icet.demo.dao.custom.ProductDao;
import org.icet.demo.dto.Product;
import org.icet.demo.dto.ProductDetails;
import org.icet.demo.dto.ViewProduct;
import org.icet.demo.entity.MeasurmentEntity;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.entity.SupplierEntity;
import org.icet.demo.util.BoType;
import org.icet.demo.util.DaoType;

import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo {

    private ProductDao productDao = DaoFactory.getInstance().getDao(DaoType.PRODUCT);
    private MeasurmentBo measurmentBo = BoFactory.getInstance().getBo(BoType.MEASURMENT);
    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);

    @Override
    public String generateId() {
        List<ProductEntity> products = getAllProducts();

        String newNumericPart = "00001";
        String prefix = "P";

        int count = 0;
        for (ProductEntity product: products){
            String id = product.getProId();

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
            return "P00001";
        }else {
            // Return the new ID
            return prefix + newNumericPart;
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productDao.retriveAll();
    }

    @Override
    public List<ProductDetails> getAllProductDetails() {

        List<ProductEntity> productData = getAllProducts();
        List<MeasurmentEntity> measurmentData = measurmentBo.getAllMeasurmentData();

        List<ProductDetails> productDetails = new ArrayList<>();

        for (ProductEntity product : productData){
            for (MeasurmentEntity measurment : measurmentData){

                if(product.getProId().equals(measurment.getProId())){

                    ProductDetails productDetailsObj = new ProductDetails();

                    productDetailsObj.setProId(product.getProId());
                    productDetailsObj.setName(product.getName());
                    productDetailsObj.setQty(measurment.getQty());
                    productDetailsObj.setSupId(product.getSupId());
                    productDetailsObj.setPrice(product.getPrice());
                    productDetailsObj.setCategory(product.getCategory());
                    productDetailsObj.setSize(measurment.getSize());

                    productDetails.add(productDetailsObj);
                }
            }
        }
        return productDetails;
    }

    @Override
    public List<ViewProduct> getDataForViewProduct() {

        List<ProductDetails> productDetails = getAllProductDetails();
        List<SupplierEntity> supplierDetails = supplierBo.getAllSuppliers();

        List<ViewProduct> viewProducts = new ArrayList<>();

        for (ProductDetails product : productDetails){
            for (SupplierEntity supplier : supplierDetails){

                if(product.getSupId().equals(supplier.getSupId())){

                    ViewProduct products = new ViewProduct();

                    products.setProId(product.getProId());
                    products.setName(product.getName());
                    products.setSupName(supplier.getName());
                    products.setSize(product.getSize());
                    products.setQty(product.getQty());
                    products.setCategory(product.getCategory());
                    products.setPrice(product.getPrice());

                    viewProducts.add(products);

                } else if (product.getSupId().equals("removed")) {

                    ViewProduct products = new ViewProduct();

                    products.setProId(product.getProId());
                    products.setName(product.getName());
                    products.setSupName("No records");
                    products.setSize(product.getSize());
                    products.setQty(product.getQty());
                    products.setCategory(product.getCategory());
                    products.setPrice(product.getPrice());

                    viewProducts.add(products);
                    break;
                }
            }
        }
        return viewProducts;
    }

    @Override
    public boolean saveProduct(Product dto) {

        ProductEntity product = new ProductEntity();

        product.setProId(dto.getProId());
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setSupId(dto.getSupId());

        return productDao.save(product);
    }

    @Override
    public ProductDetails findProductById(String id) {

        List<ProductDetails> productDetails = getAllProductDetails();

        for (ProductDetails product : productDetails){
            if(product.getProId().equals(id)){
                return product;
            }
        }

        return null;
    }

    @Override
    public boolean isProductExist(ProductDetails productDetail) {

        List<ProductDetails> productDetails = getAllProductDetails();

        for (ProductDetails product : productDetails){

            if(product.getName().equals(productDetail.getName()) &&
            product.getSize().equals(productDetail.getSize())
            ){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeSupplierId(String supId) {

        boolean isDone = false;
        List<ProductEntity> products = getAllProducts();

        for (ProductEntity product : products) {
            if (product.getSupId().equals(supId)) {

                product.setSupId("removed");
                productDao.update(product);
                isDone = true;
            }
        }
        return isDone;
    }

    @Override
    public boolean updateProduct(Product product) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProId(product.getProId());
        productEntity.setName(product.getName());
        productEntity.setSupId(product.getSupId());
        productEntity.setCategory(product.getCategory());
        productEntity.setPrice(product.getPrice());

        return productDao.update(productEntity);
    }

    @Override
    public boolean deleteProduct(Product product) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProId(product.getProId());
        return productDao.delete(productEntity);
    }
}
