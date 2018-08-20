package ru.cybernut.money.view.authorization;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.cybernut.money.controller.Controller;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.model.ArraysDataStore;
import ru.cybernut.money.model.DataStore;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyApplication extends javafx.application.Application {

    private static IController controller;
    private Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Money");
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(500);
        primaryStage.show();
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

        WindowNavigator.setMainController(mainController);
        WindowNavigator.loadPane(WindowNavigator.AUTHORIZATION_FORM);

        return mainPane;
    }


    public static void main(String[] args) {
        DataStore dataStore = new ArraysDataStore();
        controller = Controller.getInstance();
        controller.setDataStore(dataStore);
        launch(args);
    }

//    private Initializable replaceSceneContent(String fxml) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        InputStream in = MoneyApplication.class.getResourceAsStream(fxml);
//        loader.setBuilderFactory(new JavaFXBuilderFactory());
//        loader.setLocation(MoneyApplication.class.getResource(fxml));
//        AnchorPane page;
//
//        try {
//            page = (AnchorPane) loader.load(in);
//        } finally {
//            in.close();
//        }
//        root.getChildren().removeAll();
//        root.getChildren().addAll(page);
//
//        return (Initializable) loader.getController();
//    }

    public static IController getController() {
        return controller;
    }

}
