package ru.cybernut.money.view;

import javafx.fxml.FXMLLoader;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.view.authorization.StartFormController;
import ru.cybernut.money.view.main.MainWindowController;

import java.io.IOException;

public class MainWindowNavigator {

    private static IController controller;

    public static final String MAIN_FORM = "\\main\\mainWindow.fxml";
    public static final String CATEGORIES_PANE = "\\main\\categoriesPane.fxml";
    public static final String OPERATIONS_PANE = "\\main\\operationsPane.fxml";

    private static MoneyApplication moneyApplication;
    private static MainWindowController mainWindowController;

    public static MoneyApplication getMoneyApplication() {
        return moneyApplication;
    }

    public static void setMoneyApplication(MoneyApplication moneyApplication) {
        MainWindowNavigator.moneyApplication = moneyApplication;
    }

    public static void setController(IController controller) {
        MainWindowNavigator.controller = controller;
    }

    public static IController getController() {
        return controller;
    }

    public static void setMainWindowController(MainWindowController mainWindowController) {
        MainWindowNavigator.mainWindowController = mainWindowController;
    }

    public static void loadPane(String fxml) {
        try {
            mainWindowController.setPane(FXMLLoader.load(MainWindowNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
