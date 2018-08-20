package ru.cybernut.money.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.cybernut.money.controller.Controller;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.model.ArraysDataStore;
import ru.cybernut.money.model.DataStore;

import javax.xml.crypto.Data;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyApplication extends javafx.application.Application {
    private static IController controller;

    private Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("forms\\authorizationForm.fxml"));
        primaryStage.setTitle("Money");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(500);
        primaryStage.show();
    }

    private Parent createContent() {
        gotoLogin();
        //gotoRegistration();
        return root;
    }

    public static void main(String[] args) {
        DataStore dataStore = new ArraysDataStore();
        controller = Controller.getInstance();
        controller.setDataStore(dataStore);
        launch(args);
    }

    private void gotoLogin() {
        try {
            LoginController login = (LoginController)replaceSceneContent("forms\\authorizationForm.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoRegistration() {
        try {
            RegistrationController register = (RegistrationController)replaceSceneContent("forms\\registrationForm.fxml");
            register.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MoneyApplication.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MoneyApplication.class.getResource(fxml));
        AnchorPane page;

        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        root.getChildren().removeAll();
        root.getChildren().addAll(page);

        return (Initializable)loader.getController();
    }

    public static IController getController() {
        return controller;
    }

}
