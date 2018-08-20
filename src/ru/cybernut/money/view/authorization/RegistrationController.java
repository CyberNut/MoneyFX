package ru.cybernut.money.view.authorization;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ru.cybernut.money.controller.IController;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends AnchorPane implements Initializable {

    @FXML
    public TextField userName;
    @FXML
    public PasswordField password;

    private IController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setPromptText("username");
        password.setPromptText("password");

        controller = WindowNavigator.getController();
    }

    public void onCancel(ActionEvent actionEvent) {

    }

    public void onOk(ActionEvent actionEvent) {

    }

    public void onAuthorise(ActionEvent actionEvent) {
        WindowNavigator.loadPane(WindowNavigator.AUTHORIZATION_FORM);
    }
}
