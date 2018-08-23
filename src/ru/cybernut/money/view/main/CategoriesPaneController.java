package ru.cybernut.money.view.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import ru.cybernut.money.controller.IController;
import ru.cybernut.money.model.Category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CategoriesPaneController implements Initializable {

    IController controller;

    @FXML
    public AnchorPane categoriesPane;
    @FXML
    public TreeView categoriesTree;

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public void update() {
        if (controller != null) {
            List<Category> categoryList = controller.getCategories();
            final TreeItem<String> treeRoot = new TreeItem<>("Статьи доходов и расходов");
            for (Category category : categoryList) {
                treeRoot.getChildren().add(new TreeItem<>(category.getName()));
            }
            categoriesTree.setShowRoot(true);
            categoriesTree.setRoot(treeRoot);
            treeRoot.setExpanded(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
