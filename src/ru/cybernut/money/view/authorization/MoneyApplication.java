package ru.cybernut.money.view.authorization;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.cybernut.money.controller.Controller;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.model.ArraysDataStore;
import ru.cybernut.money.model.DataStore;

import java.io.IOException;

public class MoneyApplication extends javafx.application.Application {

    private static IController controller;
    private Group root = new Group();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Money");
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(500);
        primaryStage.show();
        WindowNavigator.setMoneyApplication(this);
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        //scene.getStylesheets().setAll(getClass().getResource("vista.css").toExternalForm());
        return scene;
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(WindowNavigator.STARTING_FORM));

        StartFormController mainController = loader.getController();
        WindowNavigator.setStartFormController(mainController);
        WindowNavigator.setController(controller);
        WindowNavigator.loadPane(WindowNavigator.AUTHORIZATION_FORM);


        return mainPane;
    }

    public void showMainWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(WindowNavigator.MAIN_FORM));
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
