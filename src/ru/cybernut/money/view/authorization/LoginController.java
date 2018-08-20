package ru.cybernut.money.view.authorization;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.cybernut.money.controller.IController;

/**
 * Login Controller.
 */
public class LoginController extends AnchorPane implements Initializable {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;

    private IController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setPromptText("username");
        password.setPromptText("password");
        controller = WindowNavigator.getController();
    }

    public void onOk(ActionEvent event) {
        boolean result = controller.authoriseUser(userName.getText(), password.getText());
        System.out.println(result);
        if (result) {
        }
    }

    public void onCancel(ActionEvent actionEvent) {
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public void onRegister(ActionEvent actionEvent) {
        WindowNavigator.loadPane(WindowNavigator.REGISTRATION_FORM);
    }

    public void onForgetPassword(ActionEvent actionEvent) {
        System.out.println("It is not working now.");
    }
}