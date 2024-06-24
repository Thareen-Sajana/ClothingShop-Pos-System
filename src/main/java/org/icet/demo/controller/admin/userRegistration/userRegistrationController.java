package org.icet.demo.controller.admin.userRegistration;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.hibernate.Session;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.AuthenticateBo;
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dto.Authentication;
import org.icet.demo.dto.User;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.HibernateUtil;
import org.icet.demo.util.PassBasedEnc;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.icet.demo.util.BoType.AUTHENTICATE;
import static org.icet.demo.util.BoType.USER;

public class userRegistrationController implements Initializable {
    public JFXButton loginBtnId;
    public JFXComboBox genderComboBoxId;
    public JFXComboBox roleComboBoxId;
    public JFXComboBox positionComboBoxId;
    public AnchorPane adminUserRegistrationAnchor;
    public JFXButton viewBtnId;
    public JFXButton updateBtnId;
    public JFXButton removeBtnId;
    public JFXButton securityBtnId;
    public JFXButton reportBtnId;
    public Text userIdTxt;
    public TextField firstNameTxtId;
    public TextField lastNameTxtId;
    public TextField emailTxtId;
    public TextField contactNoTxtId;
    public PasswordField passwordTxtId;
    public DatePicker birthdayTxtId;

    private UserBo userBo = BoFactory.getInstance().getBo(USER);
    private AuthenticateBo authenticateBo = BoFactory.getInstance().getBo(AUTHENTICATE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        genderComboBoxId.setItems(FXCollections.observableArrayList("Male","Female"));
        roleComboBoxId.setItems(FXCollections.observableArrayList("Admin","User"));
        positionComboBoxId.setItems(FXCollections.observableArrayList("Manger","Cashier","Salesmen","Cleaner","Security"));

        // Generate user ID :
        userIdTxt.setText(generateUserId());

//        UserEntity user = new UserEntity();
//        user.setUserId("U00002");
//        user.setFirstName("Duleesha");
//        user.setLastName("Sewmini");
//        user.setGender("Female");
//        user.setRole("Admin");
//        user.setPosition("Manager");
//        user.setContactNo("0712847741");
//        user.setEmail("duleeshasewmini@gmail.com");
//        user.setBirthday("2003/11/05");
//
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//        session.persist(user);
//        session.getTransaction().commit();
//        session.close();


        /* generates the Salt value. It can be stored in a database. */



//        /* verify the original password and encrypted password */
//        Boolean status = PassBasedEnc.verifyUserPassword("thareen12",
//                "DJNbqx41aOnUQ1q3wUitUNrkVaI5V8wSbxe2wb+xc78=",
//                "iXJ8E9820U9Ryi9c05CbDz8PqNBVth");
//        if(status==true)
//            System.out.println("Password Matched!!");
//        else
//            System.out.println("Password Mismatched");
        birthdayTxtId.setValue(LocalDate.parse("2000-01-01"));
    }

    // Generate user ID :
    private String generateUserId(){
        return userBo.generateUserId();
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        adminUserRegistrationAnchor.getChildren().clear();
        adminUserRegistrationAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        adminUserRegistrationAnchor.getChildren().clear();
        adminUserRegistrationAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        adminUserRegistrationAnchor.getChildren().clear();
        adminUserRegistrationAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        adminUserRegistrationAnchor.getChildren().clear();
        adminUserRegistrationAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        adminUserRegistrationAnchor.getChildren().clear();
        adminUserRegistrationAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        adminUserRegistrationAnchor.getChildren().clear();
        adminUserRegistrationAnchor.getChildren().add(load);
    }


    public void registerBtn(ActionEvent actionEvent) {

        // Get user details from the GUI :
        String firstName = firstNameTxtId.getText();
        String lastName = lastNameTxtId.getText();
        String gender = (String) genderComboBoxId.getValue();
        String role = (String) roleComboBoxId.getValue();
        String position = (String) positionComboBoxId.getValue();
        String email = emailTxtId.getText();
        String contactNo = contactNoTxtId.getText();
        String birthday =  birthdayTxtId.getValue().toString();
        String password = passwordTxtId.getText();
        String userId = userIdTxt.getText();

        // Create user object and save the user details on it :
        User user = new User();

        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setRole(role);
        user.setPosition(position);
        user.setEmail(email);
        user.setContactNo(contactNo);
        user.setBirthday(birthday);


        String saltvalue = PassBasedEnc.getSaltvalue(30);

        /* generates an encrypted password. It can be stored in a database.*/
        String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue);


        // Create authentication object and save the details on it :
        Authentication authentication = new Authentication();

        authentication.setUserId(userId);
        authentication.setPassword(encryptedpassword);
        authentication.setSaltValue(saltvalue);

        boolean isAuthenticationSaved = false;
        boolean isUserDetailsSaved = false;

        // Create an alert object :
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // if user not exist in the database it allows to add user :
        boolean isUserExist = userBo.isAvailable(user);

        if(!isUserExist && !isEmpty()){
            isAuthenticationSaved = authenticateBo.saveUsercredentials(authentication);
            isUserDetailsSaved = userBo.saveUser(user);
        }

        if(isUserExist){
            alert.setTitle("Duplicate user");
            alert.setContentText("User Already exist");
        }

        if (isAuthenticationSaved && isUserDetailsSaved){
            alert.setTitle("Successful");
            alert.setContentText("User Successfully Added");
            userIdTxt.setText(generateUserId());
            clear();
        }

        if(isEmpty()){
            alert.setTitle("Something went wrong");
            alert.setContentText("Please fill all the text fields");
        }

        alert.show();

    }

    public void clearBtn(ActionEvent actionEvent) {
        clear();
    }

    private void clear(){
        firstNameTxtId.setText("");
        lastNameTxtId.setText("");
        genderComboBoxId.setValue("Gender");
        roleComboBoxId.setValue("Role");
        positionComboBoxId.setValue("Position");
        emailTxtId.setText("");
        contactNoTxtId.setText("");
        birthdayTxtId.setValue(LocalDate.parse("2000-01-01"));
        passwordTxtId.setText("");
    }

    private boolean isEmpty(){
        String firstName = firstNameTxtId.getText().strip();
        String lastName = lastNameTxtId.getText().strip();
        String gender = (String) genderComboBoxId.getValue();
        String role = (String) roleComboBoxId.getValue();
        String position = (String) positionComboBoxId.getValue();
        String email = emailTxtId.getText().strip();
        String contactNo = contactNoTxtId.getText().strip();
        String birthday =  birthdayTxtId.getValue().toString().strip();
        String password = passwordTxtId.getText();

        if(firstName.equals("") || lastName.equals("") || gender.equals("")
                || role.equals("") || position.equals("") || email.equals("")
         || contactNo.equals("") || birthday.equals("") || password.equals("")){
            return true;
        }
        return false;
    }

}
