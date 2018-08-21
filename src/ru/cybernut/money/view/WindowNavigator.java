package ru.cybernut.money.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.view.authorization.StartFormController;

import java.io.IOException;

public class WindowNavigator {

    private static IController controller;

    public static final String STARTING_FORM = "\\authorization\\startingForm.fxml";
    public static final String AUTHORIZATION_FORM = "\\authorization\\authorizationForm.fxml";
    public static final String REGISTRATION_FORM = "\\authorization\\registrationForm.fxml";
    public static final String MAIN_FORM = "\\main\\mainWindow.fxml";
    public static final String CATEGORIES_PANE = "\\main\\categoriesPane.fxml";
    public static final String OPERATIONS_PANE = "\\main\\operationsPane.fxml";


    private static StartFormController startFormController;
    private static MoneyApplication moneyApplication;

    public static MoneyApplication getMoneyApplication() {
        return moneyApplication;
    }

    public static void setMoneyApplication(MoneyApplication moneyApplication) {
        WindowNavigator.moneyApplication = moneyApplication;
    }

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

        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(WindowNavigator.class.getResourceAsStream(fxml));
        Object formController = loader.getController();

        try {
            startFormController.setPane(FXMLLoader.load(WindowNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void loadPane(String fxml) {
        try {
            startFormController.setPane(FXMLLoader.load(WindowNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
