package ru.cybernut.money.view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import ru.cybernut.money.controller.Controller;
import ru.cybernut.money.controller.IController;

public class FormController {


    public PasswordField password;
    public TextField userName;

    private IController controller;

    public FormController() {
        this.controller = Controller.getInstance();
    }

    public IController getController() {

        controller = Controller.getInstance();
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public void onCancel(ActionEvent actionEvent) {
        Scene scene = ((Node)actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public void onOk(ActionEvent actionEvent) {
        boolean result = controller.authoriseUser(userName.getText(), password.getText());
        System.out.println(result);

    }


    public void onRegister(MouseEvent mouseEvent) {
        System.out.println("Register");
    }
}
