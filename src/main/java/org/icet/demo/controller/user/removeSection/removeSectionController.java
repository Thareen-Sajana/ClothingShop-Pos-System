package org.icet.demo.controller.user.removeSection;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class removeSectionController {
    public AnchorPane userRemoveSectionAnchor;

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeProductForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }

    public void removeSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSupplierForm.fxml")).load();
        userRemoveSectionAnchor.getChildren().clear();
        userRemoveSectionAnchor.getChildren().add(load);
    }
}
