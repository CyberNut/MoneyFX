package ru.cybernut.money.view;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ru.cybernut.money.view.MoneyApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends AnchorPane implements Initializable {

    public TextField userName;
    public PasswordField password;
    private MoneyApplication application;


    public void setApp(MoneyApplication application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setPromptText("username");
        password.setPromptText("password");
    }

    public void onCancel(ActionEvent actionEvent) {

    }

    public void onOk(ActionEvent actionEvent) {

    }
}
