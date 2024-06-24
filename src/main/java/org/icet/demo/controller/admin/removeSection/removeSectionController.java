package org.icet.demo.controller.admin.removeSection;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class removeSectionController {
    public AnchorPane AdminRemoveSectionAnchor;

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeUserBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeUser.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeProduct.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSupplier.fxml")).load();
        AdminRemoveSectionAnchor.getChildren().clear();
        AdminRemoveSectionAnchor.getChildren().add(load);
    }
}
