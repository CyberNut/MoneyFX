package ru.cybernut.money.view.authorization;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class WindowNavigator {

    public static final String STARTING_FORM = "startingForm.fxml";
    public static final String AUTHORIZATION_FORM = "authorizationForm.fxml";
    public static final String REGISTRATION_FORM = "registrationForm.fxml";

    private static StartFormController startFormController;

    public static void setMainController(StartFormController startFormController) {
        WindowNavigator.startFormController = startFormController;
    }

    public static void loadVista(String fxml) {
        try {
            startFormController.setPane(FXMLLoader.load(WindowNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
