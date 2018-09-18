package ru.cybernut.money.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.cybernut.money.controller.Controller;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.model.ArraysDataStore;
import ru.cybernut.money.model.DataStore;
import ru.cybernut.money.view.authorization.StartFormController;

import java.io.IOException;

public class MoneyApplication extends javafx.application.Application {

    private static IController controller;
    private Group root = new Group();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Money");
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(500);
        primaryStage.show();
        LoginWindowNavigator.setMoneyApplication(this);
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        //scene.getStylesheets().setAll(getClass().getResource("vista.css").toExternalForm());
        return scene;
    }

    private Pane loadMainPane() {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = null;
        try {
            mainPane = (Pane) loader.load(getClass().getResourceAsStream(LoginWindowNavigator.STARTING_FORM));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StartFormController mainController = loader.getController();
        LoginWindowNavigator.setStartFormController(mainController);
        LoginWindowNavigator.setController(controller);
        LoginWindowNavigator.loadPane(LoginWindowNavigator.AUTHORIZATION_FORM);

        return mainPane;
    }

    public void showMainWindow() {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = null;
        try {
            mainPane = (Pane) loader.load(getClass().getResourceAsStream(MainWindowNavigator.MAIN_FORM));
            MainWindowNavigator.setMainWindowController(loader.getController());
            MainWindowNavigator.setMoneyApplication(this);
            MainWindowNavigator.setController(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DataStore dataStore = new ArraysDataStore();
        controller = Controller.getInstance();
        controller.setDataStore(dataStore);
        launch(args);
    }

    public static IController getController() {
        return controller;
    }

}
