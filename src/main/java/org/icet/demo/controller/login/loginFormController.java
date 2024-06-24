package org.icet.demo.controller.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.AuthenticateBo;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginFormController {
    public JFXButton loginBtnId;
    public AnchorPane loginFormAnchor;
    public JFXTextField emaitTxtId;
    public JFXPasswordField passwordTxtId;

    private AuthenticateBo authenticateBo = BoFactory.getInstance().getBo(BoType.AUTHENTICATE);

    public void loginBtn(ActionEvent actionEvent) throws IOException {

        String email = emaitTxtId.getText();
        String password = passwordTxtId.getText();

        String access = authenticateBo.isAuthorized(email,password);

        if(access != null) {
            if (access.equals("Admin")) {
                Parent loadAdmin = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
                loginFormAnchor.getChildren().clear();
                loginFormAnchor.getChildren().add(loadAdmin);

            } else if (access.equals("User")) {
                Parent loadUser = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
                loginFormAnchor.getChildren().clear();
                loginFormAnchor.getChildren().add(loadUser);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong");
            alert.setContentText("Invalid username or password");
            alert.show();
        }
    }


    public void fogetPasswordBtn(ActionEvent actionEvent) throws IOException {
        Parent loadAdmin = new FXMLLoader(getClass().getResource("/view/security.fxml")).load();
        loginFormAnchor.getChildren().clear();
        loginFormAnchor.getChildren().add(loadAdmin);
    }

}
