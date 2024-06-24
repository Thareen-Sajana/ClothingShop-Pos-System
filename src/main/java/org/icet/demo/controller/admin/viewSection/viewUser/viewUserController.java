package org.icet.demo.controller.admin.viewSection.viewUser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dto.User;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class viewUserController implements Initializable {
    public AnchorPane AdminViewUserAnchor;
    public TableView viewUserTable;
    public TableColumn userIdColomn;
    public TableColumn userNameColomn;
    public TableColumn positionColomn;
    public TableColumn contactNoColomn;
    public TableColumn gentderColomn;
    public TableColumn birthdayColomn;
    public TableColumn emailColomn;

    UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userIdColomn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userNameColomn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        contactNoColomn.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        positionColomn.setCellValueFactory(new PropertyValueFactory<>("position"));
        gentderColomn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        emailColomn.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthdayColomn.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        ObservableList<UserEntity> allUsers = FXCollections.observableArrayList();

        List<UserEntity> userEntities = userBo.getAllUsers();

        for (UserEntity user : userEntities){
            allUsers.add(user);
        }

        viewUserTable.setItems(allUsers);

    }

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminViewUserAnchor.getChildren().clear();
        AdminViewUserAnchor.getChildren().add(load);
    }


}
