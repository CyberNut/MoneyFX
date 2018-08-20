package ru.cybernut.money.view.authorization;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class StartFormController {

    @FXML
    public AnchorPane mainPane;

    public void setPane(Node node) {
        mainPane.getChildren().setAll(node);
    }
}
