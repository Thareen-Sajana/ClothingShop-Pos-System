package org.icet.demo.controller.user.removeSection.removeSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dao.custom.ProductDao;
import org.icet.demo.dto.Supplier;
import org.icet.demo.util.BoType;

import java.io.IOException;

public class removeSupplierController {
    public AnchorPane userRemoveSupplierAnchor;
    public TextField supplierIdTxt;
    public TextField nameTxt;
    public TextField companyTxt;
    public TextField emailTxt;

    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);
    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userRemoveSupplierAnchor.getChildren().clear();
        userRemoveSupplierAnchor.getChildren().add(load);
    }

    public void removeSupplierRowBtn(ActionEvent actionEvent) {

        String supplierID = supplierIdTxt.getText().strip();

        Supplier supplier = supplierBo.findSupplierById(supplierID);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(supplier != null){
            boolean isDeleted = supplierBo.delete(supplier);
            boolean isRemoveSupId = productBo.removeSupplierId(supplierID);

            if(isDeleted && isRemoveSupId){
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
