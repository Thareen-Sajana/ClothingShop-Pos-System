package org.icet.demo.bo.custom;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dto.Product;
import org.icet.demo.dto.ProductDetails;
import org.icet.demo.dto.Supplier;
import org.icet.demo.dto.ViewProduct;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.entity.SupplierEntity;

import java.util.List;

public interface ProductBo extends SuperBo {

    String generateId();

    List<ProductEntity> getAllProducts();
    List<ProductDetails> getAllProductDetails();

    List<ViewProduct> getDataForViewProduct();

    boolean saveProduct(Product dto);

    ProductDetails findProductById(String id);

    boolean isProductExist(ProductDetails productDetail);

    boolean removeSupplierId(String supId);

    boolean updateProduct(Product product);

    boolean deleteProduct(Product product);
}
