package org.icet.demo.controller.user.viewSection;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class viewSectionController {
    public AnchorPane userViewSectionAnchor;

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void viewUserBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewUserForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void viewProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewProductForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void viewSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSupplierForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }

    public void viewOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewOrdersForm.fxml")).load();
        userViewSectionAnchor.getChildren().clear();
        userViewSectionAnchor.getChildren().add(load);
    }
}
