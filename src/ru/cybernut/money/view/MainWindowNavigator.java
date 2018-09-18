package ru.cybernut.money.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.view.authorization.StartFormController;
import ru.cybernut.money.view.main.CategoriesPaneController;
import ru.cybernut.money.view.main.MainWindowController;

import java.io.IOException;

public class MainWindowNavigator {

    private static IController controller;

    public static final String MAIN_FORM = "main/mainWindow.fxml";
    public static final String CATEGORIES_PANE = "main/categoriesPane.fxml";
    public static final String OPERATIONS_PANE = "main/operationsPane.fxml";

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

    public static void showCategories() {
        FXMLLoader loader = new FXMLLoader();
        try {
            MainWindowNavigator.mainWindowController.setMainPane((Pane)loader.load(MainWindowNavigator.class.getResourceAsStream(MainWindowNavigator.CATEGORIES_PANE)));
            CategoriesPaneController categoriesPaneController = (CategoriesPaneController)loader.getController();
            categoriesPaneController.setController(MainWindowNavigator.controller);
            categoriesPaneController.update();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadMainPane(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = null;
        try {
            mainPane = (Pane) loader.load(MainWindowNavigator.class.getResourceAsStream(fxml));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(mainPane != null) {
            mainWindowController.setMainPane(mainPane);
        }
    }

}
