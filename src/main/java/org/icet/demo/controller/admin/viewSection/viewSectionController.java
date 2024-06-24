package org.icet.demo.controller.admin.viewSection;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class viewSectionController {
    public JFXButton registerBtnId;
    public JFXButton viewBtnId;
    public JFXButton securityBtnId;
    public JFXButton loginBtnIn;
    public AnchorPane AdminViewSectionAnchor;

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void viewUserBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewUserForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void viewProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewProductForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void viewSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSupplierForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }

    public void viewOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewOrderForm.fxml")).load();
        AdminViewSectionAnchor.getChildren().clear();
        AdminViewSectionAnchor.getChildren().add(load);
    }
}
