package org.icet.demo.controller.user.addSection.addProduct;


import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.MeasurmentBo;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dto.Measurment;
import org.icet.demo.dto.Product;
import org.icet.demo.dto.ProductDetails;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.icet.demo.util.BoType.*;

public class addProductController implements Initializable {
    public AnchorPane addProductAnchor;
    public TextField productNameTxt;
    public TextField priceTxt;
    public JFXComboBox supplierIdComboBoxId;
    public JFXComboBox categoryComboBoxId;
    public TextField qtyTxt;
    public JFXComboBox sizeComboBoxId;
    public Text productIdTxt;

    private ProductBo productBo = BoFactory.getInstance().getBo(PRODUCT);
    private SupplierBo supplierBo = BoFactory.getInstance().getBo(SUPPLIER);

    private MeasurmentBo measurmentBo = BoFactory.getInstance().getBo(MEASURMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String productId = generateID();
        productIdTxt.setText(productId);

        categoryComboBoxId.setItems(FXCollections.observableArrayList("Mens","Women's","Kids"));
        sizeComboBoxId.setItems(FXCollections.observableArrayList("S","M","L","XL","XXL","XXXL"));
        supplierIdComboBoxId.setItems(FXCollections.observableArrayList(getAllSupplierId()));
    }

    private ObservableList<String> getAllSupplierId(){
        ObservableList<String> supIds = FXCollections.observableArrayList();
        List<String> supplierIdList = supplierBo.getSupplierId();

        if(supplierIdList != null){
            for (String id : supplierIdList){
                supIds.add(id);
            }
            return supIds;
        }
        supIds.add("No data");
        return supIds;
    }


    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        addProductAnchor.getChildren().clear();
        addProductAnchor.getChildren().add(load);
    }

    public void addProductDetailsBtn(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(!isEmpty()){

            ProductDetails productDetails = new ProductDetails();

            productDetails.setProId(productIdTxt.getText());
            productDetails.setName(productNameTxt.getText().strip());
            productDetails.setQty(Integer.valueOf(qtyTxt.getText().strip()));
            productDetails.setSupId(supplierIdComboBoxId.getValue().toString());
            productDetails.setPrice(Double.valueOf(priceTxt.getText().strip()));
            productDetails.setCategory(categoryComboBoxId.getValue().toString());
            productDetails.setSize(sizeComboBoxId.getValue().toString());

            boolean isProductExist = productBo.isProductExist(productDetails);

            Product product = new Product();
            product.setProId(productDetails.getProId());
            product.setName(productDetails.getName());
            product.setCategory(productDetails.getCategory());
            product.setPrice(productDetails.getPrice());
            product.setSupId(productDetails.getSupId());

            Measurment measurment = new Measurment();
            measurment.setProId(productDetails.getProId());
            measurment.setQty(productDetails.getQty());
            measurment.setSize(productDetails.getSize());


            if(!isProductExist){

                boolean isProductAdded = productBo.saveProduct(product);
                boolean isMeasurmentAdded = measurmentBo.saveMeasurements(measurment);

                if(isProductAdded && isMeasurmentAdded){
                    alert.setTitle("Done");
                    alert.setContentText("Successfully added product");

                    clear();

                    String productId = generateID();
                    productIdTxt.setText(productId);

                }else {
                    alert.setTitle("Something went wrong");
                    alert.setContentText("You can not add this product");
                }
            }else {
                alert.setTitle("Duplicate Product");
                alert.setContentText("Product Already exist");
            }

        }else {
            alert.setTitle("Error");
            alert.setContentText("Please fill all details");
        }

        alert.show();
    }

    private String generateID(){
        return productBo.generateId();
    }

    private void clear(){

        productNameTxt.clear();
        qtyTxt.clear();
        priceTxt.clear();

    }

    private boolean isEmpty(){

        if(productNameTxt.getText().strip().equals("") ||
        qtyTxt.getText().strip().equals("") ||
        supplierIdComboBoxId.getValue().toString().equals("") ||
        priceTxt.getText().strip().equals("") ||
        categoryComboBoxId.getValue().toString().equals("") ||
        sizeComboBoxId.getValue().toString().equals("")){
            return true;
        }
        return false;
    }


}
