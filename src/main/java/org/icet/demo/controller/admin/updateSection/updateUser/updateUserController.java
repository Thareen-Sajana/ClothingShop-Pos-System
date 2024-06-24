package org.icet.demo.controller.admin.updateSection.updateUser;

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
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dto.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.icet.demo.util.BoType.USER;

public class updateUserController implements Initializable {
    public AnchorPane adminUpdateUserAnchor;
    public DatePicker birthdayTxtId;
    public JFXComboBox positionComboBoxId;
    public JFXComboBox roleComboBoxId;
    public JFXComboBox genderComboBoxId;
    public TextField emailTxtId;
    public TextField contactNoTxtId;
    public TextField nameTxtId;
    public TextField userIdSearchTxtId;

    private UserBo userBo = BoFactory.getInstance().getBo(USER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderComboBoxId.setItems(FXCollections.observableArrayList("Male","Female"));
        roleComboBoxId.setItems(FXCollections.observableArrayList("Admin","User"));
        positionComboBoxId.setItems(FXCollections.observableArrayList("Manager","Cashier","Salesmen","Cleaner","Security"));

    }

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        adminUpdateUserAnchor.getChildren().clear();
        adminUpdateUserAnchor.getChildren().add(load);
    }

    public void searchBtn(ActionEvent actionEvent) {

        String userID = userIdSearchTxtId.getText().strip();
        User user = userBo.getUserById(userID);

        if(user != null){
            nameTxtId.setText(user.getFirstName());
            birthdayTxtId.setValue(LocalDate.parse(user.getBirthday()));
            genderComboBoxId.setValue(user.getGender());
            roleComboBoxId.setValue(user.getRole());
            positionComboBoxId.setValue(user.getPosition());
            emailTxtId.setText(user.getEmail());
            contactNoTxtId.setText(user.getContactNo());

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Can not find user");
            alert.setContentText("User does not exist");
            alert.show();
        }
    }

    public void updateUserDetailsBtn(ActionEvent actionEvent) {

        User user = new User();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        user.setUserId(userIdSearchTxtId.getText());
        user.setFirstName(nameTxtId.getText());
        user.setBirthday(birthdayTxtId.getValue().toString());
        user.setGender(genderComboBoxId.getValue().toString());
        user.setRole(roleComboBoxId.getValue().toString());
        user.setPosition(positionComboBoxId.getValue().toString());
        user.setEmail(emailTxtId.getText());
        user.setContactNo(contactNoTxtId.getText());

        boolean isUserExist = userBo.isUserExist(userIdSearchTxtId.getText());
        boolean isUpdated = false;

        if(isUserExist){
            String userLastName = userBo.getUserById(userIdSearchTxtId.getText()).getLastName();
            user.setLastName(userLastName);
            isUpdated = userBo.updateUser(user);

        }else {
            alert.setTitle("Can not find user");
            alert.setContentText("User does not exist you can not Update");
        }

        if (isUpdated){
            alert.setTitle("Updated");
            alert.setContentText("Update Successful");
        }else {
            alert.setTitle("Something went wrong");
            alert.setContentText("Update does not Successful");
        }

        alert.show();

    }


}
