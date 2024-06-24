package org.icet.demo.controller.user.updateSection;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class updateSectionController {
    public AnchorPane userUpdateSectionAnchor;

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateProductForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }

    public void updateSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSupplierForm.fxml")).load();
        userUpdateSectionAnchor.getChildren().clear();
        userUpdateSectionAnchor.getChildren().add(load);
    }
}
