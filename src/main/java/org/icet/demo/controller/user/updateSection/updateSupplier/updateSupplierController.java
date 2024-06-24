package org.icet.demo.controller.user.updateSection.updateSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dto.Supplier;
import org.icet.demo.util.BoType;

import java.io.IOException;

public class updateSupplierController {
    public AnchorPane userUpdateSupplierAnchor;
    public TextField searchSupplierIdTxt;
    public TextField nameTxtId;
    public TextField companyTxtId;
    public TextField emailTxtId;

    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userUpdateSupplierAnchor.getChildren().clear();
        userUpdateSupplierAnchor.getChildren().add(load);
    }

    public void updateSupplierDetailsBtn(ActionEvent actionEvent) {

        String supplierID = searchSupplierIdTxt.getText().strip();
        Supplier supplier = supplierBo.findSupplierById(supplierID);

        boolean isUpdated = false;

        if(supplier != null){

            supplier.setSupId(supplierID);
            supplier.setName(nameTxtId.getText().strip());
            supplier.setCompany(companyTxtId.getText().strip());
            supplier.setEmail(emailTxtId.getText().strip());

            isUpdated = supplierBo.updateSupplier(supplier);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(isUpdated){
            alert.setTitle("Done");
            alert.setContentText("Successfully updated supplier");
            clear();
        }else {
            alert.setTitle("can't update");
            alert.setContentText("Something went wrong");
        }
        alert.show();
    }

    public void searchBtn(ActionEvent actionEvent) {

        String supplierID = searchSupplierIdTxt.getText().strip();

        Supplier supplier = supplierBo.findSupplierById(supplierID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(supplier != null){
            nameTxtId.setText(supplier.getName());
            emailTxtId.setText(supplier.getEmail());
            companyTxtId.setText(supplier.getCompany());
        }else {
            alert.setTitle("Invalid supplier");
            alert.setContentText("Supplier dose not exist");
            clear();
            alert.show();
        }

    }

    private void clear(){
        nameTxtId.clear();
        emailTxtId.clear();
        companyTxtId.clear();
    }
}
