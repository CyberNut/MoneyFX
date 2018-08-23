package ru.cybernut.money.view;

import javafx.fxml.FXMLLoader;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.view.authorization.StartFormController;

import java.io.IOException;

public class LoginWindowNavigator {

    private static IController controller;

    public static final String STARTING_FORM = "authorization/startingForm.fxml";
    public static final String AUTHORIZATION_FORM = "authorization/authorizationForm.fxml";
    public static final String REGISTRATION_FORM = "authorization/registrationForm.fxml";

    private static StartFormController startFormController;
    private static MoneyApplication moneyApplication;

    public static MoneyApplication getMoneyApplication() {
        return moneyApplication;
    }

    public static void setMoneyApplication(MoneyApplication moneyApplication) {
        LoginWindowNavigator.moneyApplication = moneyApplication;
    }

    public static void setController(IController controller) {
        LoginWindowNavigator.controller = controller;
    }

    public static IController getController() {
        return controller;
    }

    public static void setStartFormController(StartFormController startFormController) {
        LoginWindowNavigator.startFormController = startFormController;
    }

    public static void loadPane(String fxml) {
        try {
            startFormController.setPane(FXMLLoader.load(LoginWindowNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
