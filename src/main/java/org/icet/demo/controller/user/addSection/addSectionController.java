package org.icet.demo.controller.user.addSection;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class addSectionController {
    public AnchorPane addSectionAnchoer;

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }

    public void addProductBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addProductForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);

    }

    public void addSupplierBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSupplierForm.fxml")).load();
        addSectionAnchoer.getChildren().clear();
        addSectionAnchoer.getChildren().add(load);
    }
}
