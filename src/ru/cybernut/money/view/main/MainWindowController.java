package ru.cybernut.money.view.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.view.MainWindowNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    public AnchorPane mainPane;
    @FXML
    public AnchorPane additionalPane;

    IController controller;

    public AnchorPane getMainPane() {
        return mainPane;
    }

    public AnchorPane getAdditionalPane() {
        return additionalPane;
    }

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public void onOperations(ActionEvent actionEvent) {
    }

    public void onCategories(ActionEvent actionEvent) {
        MainWindowNavigator.loadMainPane(MainWindowNavigator.CATEGORIES_PANE);
        CategoriesPaneController categoriesPaneController = loader.getController();
        categoriesPaneController.setController(controller);
        categoriesPaneController.update();

    }

    public void onService(ActionEvent actionEvent) {

    }

    public void setMainPane(Node node) {
        mainPane.getChildren().setAll(node);
    }

    public void setAdditionalPane(Node node) {
        additionalPane.getChildren().setAll(node);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
