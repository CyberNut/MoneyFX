package ru.cybernut.money.view.authorization;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.view.WindowNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends AnchorPane implements Initializable {

    @FXML
    public TextField userName;
    @FXML
    public PasswordField password;
    @FXML
    public Label labelErrorMessage;

    private IController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setPromptText("username");
        password.setPromptText("password");

        controller = WindowNavigator.getController();
    }

    public void onCancel(ActionEvent actionEvent) {
        WindowNavigator.loadPane(WindowNavigator.AUTHORIZATION_FORM);
    }

    public void onOk(ActionEvent actionEvent) {

        String userNameText = userName.getText();
        String passwordText = password.getText();

        if (!"".equals(userNameText) && !"".equals(passwordText)) {
            if (controller.getUserByName(userName.getText()) == null) {
                if (controller.createUser(userNameText, passwordText) == true) {
                    labelErrorMessage.setText("Пользователь успешно создан!");
                    labelErrorMessage.setVisible(true);
                } else {
                    labelErrorMessage.setText("Не удалось создать пользователя!");
                    labelErrorMessage.setVisible(true);
                }
            } else {
                labelErrorMessage.setText("Пользователь с таким именем уже существует!");
                labelErrorMessage.setVisible(true);
            }
        }

    }

    public void onAuthorise(ActionEvent actionEvent) {
        WindowNavigator.loadPane(WindowNavigator.AUTHORIZATION_FORM);
    }
}
