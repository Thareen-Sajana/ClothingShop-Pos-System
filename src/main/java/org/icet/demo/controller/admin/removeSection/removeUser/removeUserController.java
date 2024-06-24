package org.icet.demo.controller.admin.removeSection.removeUser;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.AuthenticateBo;
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dto.Authentication;
import org.icet.demo.dto.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.icet.demo.util.BoType.AUTHENTICATE;
import static org.icet.demo.util.BoType.USER;

public class removeUserController implements Initializable{
    public AnchorPane adminRemoveUserAnchor;
    public TextField searchIdTxt;
    public TextField userNameTxt;
    public TextField contactNoTxt;
    public TextField emailTxt;
    public JFXComboBox genderComboBoxId;
    public JFXComboBox roleComboBoxId;
    public JFXComboBox positionComboBoxId;
    public DatePicker birthdayTxt;

    UserBo userBo = BoFactory.getInstance().getBo(USER);
    AuthenticateBo authenticateBo = BoFactory.getInstance().getBo(AUTHENTICATE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderComboBoxId.setItems(FXCollections.observableArrayList("Male","Female"));
        roleComboBoxId.setItems(FXCollections.observableArrayList("Admin","User"));
        positionComboBoxId.setItems(FXCollections.observableArrayList("Manager","Cashier","Salesmen","Cleaner","Security"));

    }

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        adminRemoveUserAnchor.getChildren().clear();
        adminRemoveUserAnchor.getChildren().add(load);
    }

    public void removeUserBtn(ActionEvent actionEvent) {

        User user = new User();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        user.setUserId(searchIdTxt.getText());

        boolean isUserExist = userBo.isUserExist(searchIdTxt.getText());
        boolean isDeleted = false;
        boolean isRemoveinAuthenticationTable = false;

        if (isUserExist){
            Authentication authentication = authenticateBo.findAuthenticationByUserId(searchIdTxt.getText());

            isDeleted = userBo.delete(user);
            isRemoveinAuthenticationTable = authenticateBo.delete(authentication);
        }else {
            alert.setTitle("Can not find user");
            alert.setContentText("User does not exist you can not Update");
        }

        if (isDeleted && isRemoveinAuthenticationTable){
            alert.setTitle("Deleted");
            alert.setContentText("Deleted Successful");
        }else {
            alert.setTitle("Something went wrong");
            alert.setContentText("Deleted does not Successful");
        }
        alert.show();
    }

    public void searchBtn(ActionEvent actionEvent) {
        String userID = searchIdTxt.getText().strip();
        User user = userBo.getUserById(userID);

        if(user != null){
            userNameTxt.setText(user.getFirstName());
            birthdayTxt.setValue(LocalDate.parse(user.getBirthday()));
            genderComboBoxId.setValue(user.getGender());
            roleComboBoxId.setValue(user.getRole());
            positionComboBoxId.setValue(user.getPosition());
            emailTxt.setText(user.getEmail());
            contactNoTxt.setText(user.getContactNo());

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Can not find user");
            alert.setContentText("User does not exist");
            alert.show();
        }
    }


}
