package org.icet.demo.controller.user.security;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.AuthenticateBo;
import org.icet.demo.util.BoType;
import org.icet.demo.util.SendEmail;

import java.io.IOException;
import java.util.Random;

public class securityController {
    public AnchorPane userSecurityAnchor;
    public TextField emailTxtId;
    public TextField otpTxtId;
    public PasswordField passwordTxtId;

    private String otp;
    private AuthenticateBo authenticateBo = BoFactory.getInstance().getBo(BoType.AUTHENTICATE);

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userSecurityAnchor.getChildren().clear();
        userSecurityAnchor.getChildren().add(load);
    }

    public void sendOtpBrn(ActionEvent actionEvent) {
        if(!emailTxtId.getText().strip().equals("")){
            this.otp = generateOtp();
            SendEmail send = new SendEmail(emailTxtId.getText(), "Rest code", this.otp);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Please Enter correct email");
            alert.show();
        }
    }

    public void saveBtn(ActionEvent actionEvent) {

        if(otp.equals(otpTxtId.getText().strip())){

            boolean isUpdated = authenticateBo.updatePassword(emailTxtId.getText().strip(),
                    passwordTxtId.getText());

            if(isUpdated){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful");
                alert.setContentText("Password change successful");
                alert.show();
                clear();
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Something went wrong while updating password");
                alert.show();
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Wrong OTP number");
            alert.show();
        }
    }

    private String generateOtp(){
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[6];
        for (int i = 0; i < 6; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return new String(otp);
    }

    private void clear(){
        emailTxtId.clear();
        otpTxtId.clear();
        passwordTxtId.clear();
    }
}
