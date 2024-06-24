package org.icet.demo.controller.admin.updateSection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class updateSectionController {
    public AnchorPane AdminUpdateSectionAnchor;

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateUserBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateUserForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateProductForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSupplierForm.fxml")).load();
        AdminUpdateSectionAnchor.getChildren().clear();
        AdminUpdateSectionAnchor.getChildren().add(load);
    }
}
