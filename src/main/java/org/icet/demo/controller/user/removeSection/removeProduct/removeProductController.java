package org.icet.demo.controller.user.removeSection.removeProduct;

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
import org.icet.demo.dto.Measurment;
import org.icet.demo.dto.Product;
import org.icet.demo.dto.ProductDetails;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class removeProductController implements Initializable {
    public AnchorPane userRemoveProductAnchor;
    public TextField productIdTxt;
    public TextField nameTxt;
    public TextField priceTxt;
    public TextField qtyTxt;
    public JFXComboBox categoryComboBoxId;

    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);
    private MeasurmentBo measurmentBo = BoFactory.getInstance().getBo(BoType.MEASURMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryComboBoxId.setItems(FXCollections.observableArrayList("Mens","Women's","Kids"));
    }

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userRemoveProductAnchor.getChildren().clear();
        userRemoveProductAnchor.getChildren().add(load);
    }

    public void searchBtn(ActionEvent actionEvent) {

        String productID = productIdTxt.getText().strip();
        ProductDetails product = productBo.findProductById(productID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(product != null){

            nameTxt.setText(product.getName());
            qtyTxt.setText(String.valueOf(product.getQty()));
            priceTxt.setText(String.valueOf(product.getPrice()));
            categoryComboBoxId.setValue(product.getCategory());

        }else {
            alert.setTitle("Not found");
            alert.setContentText("Product not found");
            alert.show();
        }
    }

    public void removeProductDetailsBtn(ActionEvent actionEvent) {

        String productID = productIdTxt.getText().strip();
        ProductDetails product = productBo.findProductById(productID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(product != null){

            Product productData = new Product();
            productData.setProId(productIdTxt.getText());

            boolean isDeleteProduct = productBo.deleteProduct(productData);

            Measurment measurment = new Measurment();
            measurment.setMeasurmentId(measurmentBo.getMeasurmentByProductId(productIdTxt.getText()).getMeasurmentId());

            boolean isMeasurmentDeeleted = measurmentBo.deleteMeasurment(measurment);

            if(isDeleteProduct && isMeasurmentDeeleted){
                alert.setTitle("Removed");
                alert.setContentText("Successfully Removed");
                clear();
            }
        }else {
            alert.setTitle("Not found");
            alert.setContentText("Product not found");
        }
        alert.show();
    }

    private void clear(){
        nameTxt.clear();
        priceTxt.clear();
        qtyTxt.clear();
    }
}
