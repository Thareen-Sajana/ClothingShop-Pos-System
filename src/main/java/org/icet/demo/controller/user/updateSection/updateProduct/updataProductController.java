package org.icet.demo.controller.user.updateSection.updateProduct;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.MeasurmentBo;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dto.Product;
import org.icet.demo.dto.ProductDetails;
import org.icet.demo.entity.MeasurmentEntity;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class updataProductController implements Initializable {
    public AnchorPane userUpdateProductAnchor;
    public TextField productIdTxt;
    public TextField productNameTxt;
    public TextField priceTxt;
    public JFXComboBox supplierComboBoxId;
    public JFXComboBox categoryComboBoxId11;
    public JFXComboBox sizeComboBoxId;
    public TextField qtyTxt;

    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);
    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);
    private MeasurmentBo measurmentBo = BoFactory.getInstance().getBo(BoType.MEASURMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        categoryComboBoxId11.setItems(FXCollections.observableArrayList("Mens","Women's","Kids"));
        sizeComboBoxId.setItems(FXCollections.observableArrayList("S","M","L","XL","XXL","XXXL"));
        supplierComboBoxId.setItems(FXCollections.observableArrayList(getAllSupplierId()));
    }

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userUpdateProductAnchor.getChildren().clear();
        userUpdateProductAnchor.getChildren().add(load);
    }

    public void updateProductDetailsBtn(ActionEvent actionEvent) {

        String productID = productIdTxt.getText().strip();
        ProductDetails product = productBo.findProductById(productID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(product != null){

            Product updateProduct = new Product();
            updateProduct.setProId(productIdTxt.getText());
            updateProduct.setName(productNameTxt.getText().strip());
            updateProduct.setPrice(Double.valueOf(priceTxt.getText()));
            updateProduct.setSupId(supplierComboBoxId.getValue().toString());
            updateProduct.setCategory(categoryComboBoxId11.getValue().toString());

            Integer measurmentId = measurmentBo.getMeasurmentByProductId(productIdTxt.getText()).getMeasurmentId();
            MeasurmentEntity measurment = new MeasurmentEntity();

            measurment.setMeasurmentId(measurmentId);
            measurment.setQty(Integer.valueOf(qtyTxt.getText()));
            measurment.setSize(sizeComboBoxId.getValue().toString());
            measurment.setProId(productIdTxt.getText());

            boolean isProductUpdated = productBo.updateProduct(updateProduct);
            boolean isMeasurmentUpdated = measurmentBo.updateMeasurment(measurment);

            if(isProductUpdated && isMeasurmentUpdated){
                alert.setTitle("Done");
                alert.setContentText("Successfully updated product");
                clear();
            }

        }else {
            alert.setTitle("Not found");
            alert.setContentText("Product not found");

        }
        alert.show();
    }

    public void searchProductIdBtn(ActionEvent actionEvent) {

        String productID = productIdTxt.getText().strip();
        ProductDetails product = productBo.findProductById(productID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(product != null){

            productNameTxt.setText(product.getName());
            qtyTxt.setText(String.valueOf(product.getQty()));
            supplierComboBoxId.setValue(product.getSupId());
            priceTxt.setText(String.valueOf(product.getPrice()));
            categoryComboBoxId11.setValue(product.getCategory());
            sizeComboBoxId.setValue(product.getSize());
        }else {
            alert.setTitle("Not found");
            alert.setContentText("Product not found");
            alert.show();
        }
    }

    private void clear(){
        productNameTxt.clear();
        qtyTxt.clear();
        priceTxt.clear();
    }
    private List<String> getAllSupplierId(){
        return supplierBo.getSupplierId();
    }
}
