package org.icet.demo.controller.user.addSection.addSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dto.Supplier;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.icet.demo.util.BoType.SUPPLIER;

public class addSupplierController implements Initializable {
    public AnchorPane addSupplierAnchor;
    public Text supplierIDTxt;
    public TextField supplierNameTxtId;
    public TextField supplierCompanyTxtId;
    public TextField supplierEmailTxtId;

    private SupplierBo supplierBo = BoFactory.getInstance().getBo(SUPPLIER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String supplierID = generateSupplierID();
        supplierIDTxt.setText(supplierID);
    }

    private String generateSupplierID(){
        return supplierBo.generateId();
    }


    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        addSupplierAnchor.getChildren().clear();
        addSupplierAnchor.getChildren().add(load);
    }

    public void addingBtn(ActionEvent actionEvent) {

        Supplier supplier = new Supplier();

        supplier.setSupId(supplierIDTxt.getText());
        supplier.setName(supplierNameTxtId.getText());
        supplier.setEmail(supplierEmailTxtId.getText());
        supplier.setCompany(supplierCompanyTxtId.getText());

        // Create an alert object :
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        boolean issaved = false;
        boolean isSupplierExist = supplierBo.isSupplierAvailable(supplier);

        if(!isSupplierExist){
            issaved = supplierBo.saveSupplier(supplier);
        }else {
            alert.setTitle("Duplicate");
            alert.setContentText("Supplier already exist");
        }


        if(issaved){
            alert.setTitle("Done");
            alert.setContentText("Successfully added supplier");

            clear();

            String supplierID = generateSupplierID();
            supplierIDTxt.setText(supplierID);
        }else {
            alert.setTitle("Something went wrong");
            alert.setContentText("You can not add this supplier");
        }

        alert.show();

    }

    private void clear(){
        supplierNameTxtId.setText("");
        supplierEmailTxtId.setText("");
        supplierCompanyTxtId.setText("");
    }


}
