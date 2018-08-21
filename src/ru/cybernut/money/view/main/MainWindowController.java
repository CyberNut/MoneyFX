package ru.cybernut.money.view.main;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import ru.cybernut.money.controller.IController;

public class MainWindowController {

    @FXML
    public AnchorPane mainPane;
    @FXML
    public AnchorPane additionalPane;

    IController controller;

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public void setMainPane(Node node) {
        mainPane.getChildren().setAll(node);
    }

    public void showMainWindow() {

    }
}
