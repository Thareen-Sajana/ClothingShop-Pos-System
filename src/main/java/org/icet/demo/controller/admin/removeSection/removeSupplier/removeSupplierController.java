package org.icet.demo.controller.admin.removeSection.removeSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dto.Supplier;
import org.icet.demo.util.BoType;

import java.io.IOException;

public class removeSupplierController {
    public AnchorPane adminRemoveSupplierAnchor;
    public TextField supplierIdTxt;
    public TextField nameTxt;
    public TextField companyTxt;
    public TextField emailTxt;
    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);
    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        adminRemoveSupplierAnchor.getChildren().clear();
        adminRemoveSupplierAnchor.getChildren().add(load);
    }

    public void removeSupplierRowBtn(ActionEvent actionEvent) {

        String supplierID = supplierIdTxt.getText().strip();

        Supplier supplier = supplierBo.findSupplierById(supplierID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(supplier != null){
            boolean isDeleted = supplierBo.delete(supplier);
            boolean isRemoveSupId = productBo.removeSupplierId(supplierID);

            if(isDeleted || isRemoveSupId){
                alert.setTitle("Removed");
                alert.setContentText("Successfully removed the supplier");
                clear();
            }else {
                alert.setTitle("Error");
                alert.setContentText("Something went wrong");
            }

        }else {
            alert.setTitle("Can not remove");
            alert.setContentText("Supplier not found");
        }
        alert.show();
    }

    public void searchBtn(ActionEvent actionEvent) {

        String supplierID = supplierIdTxt.getText().strip();

        Supplier supplier = supplierBo.findSupplierById(supplierID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(supplier != null){

            nameTxt.setText(supplier.getName());
            emailTxt.setText(supplier.getEmail());
            companyTxt.setText(supplier.getCompany());

        }else {
            alert.setTitle("Not found");
            alert.setContentText("Supplier not found");
            alert.show();
        }

    }
    private void clear(){
        nameTxt.clear();
        emailTxt.clear();
        companyTxt.clear();
    }
}
