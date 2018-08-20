package ru.cybernut.money.view.authorization;

import javafx.fxml.FXMLLoader;
import ru.cybernut.money.controller.IController;

import java.io.IOException;

public class WindowNavigator {

    private static IController controller;

    public static final String STARTING_FORM = "startingForm.fxml";

    public static final String AUTHORIZATION_FORM = "authorizationForm.fxml";
    public static final String REGISTRATION_FORM = "registrationForm.fxml";
    private static StartFormController startFormController;


    public static void setController(IController controller) {
        WindowNavigator.controller = controller;
    }

    public static IController getController() {
        return controller;
    }

    public static void setStartFormController(StartFormController startFormController) {
        WindowNavigator.startFormController = startFormController;
    }

    public static void loadPane(String fxml) {
        try {
            startFormController.setPane(FXMLLoader.load(WindowNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
