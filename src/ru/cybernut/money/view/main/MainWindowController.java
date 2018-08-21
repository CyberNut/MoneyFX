package ru.cybernut.money.view.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import ru.cybernut.money.controller.IController;

public class MainWindowController {

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

    public void setPane(Node node, Pane pane) {
        pane.getChildren().setAll(node);
    }

    public void onOperations(ActionEvent actionEvent) {
    }

    public void onCategories(ActionEvent actionEvent) {


    }

    public void onService(ActionEvent actionEvent) {

    }
}
