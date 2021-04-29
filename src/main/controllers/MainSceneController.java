package org.eleven.controllers;

import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.eleven.Launcher;
import org.eleven.entities.Item;
import org.eleven.entities.Menu;
import org.eleven.resource.ColorPalette;
import org.eleven.resource.RequestHandler;
import org.eleven.resource.SceneLoader;
import org.eleven.resource.TableGridExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainSceneController implements Controller{

    @FXML MenuItem logOutButton;
    @FXML MenuBar menuBar;
    @FXML GridPane tableGrid;
    @FXML TableView tableMenu;
    ArrayList<Button> tableButtons = new ArrayList<>();
    ArrayList<Region> tableRegions = new ArrayList<>();
    ArrayList<Item> menuItems = Menu.items();
    TableColumn<Item, String> menuColumn1 = new TableColumn<>("ItemID");
    TableColumn<Item, String> menuColumn2 = new TableColumn<>("ItemName");
    TableColumn<Item, String> menuColumn3 = new TableColumn<>("ItemPrice");
    TableColumn<Item, String> menuColumn4 = new TableColumn<>("ItemType");

    public void logOutButtonPressed(ActionEvent event) {
        Scene loginScene = SceneLoader.load_scene("login_scene_layout").scene();
        Stage primaryStage = (Stage) menuBar.getScene().getWindow();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Automation Project - Login");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(563);
        primaryStage.show();
    }

    public void initialize() {
        //Table Grid Button and Region Initialization
        for(int i = 0; i < tableGrid.getChildren().size(); i++) {
            Node node = tableGrid.getChildren().get(i);
            if(node instanceof Button) {
                tableButtons.add((Button) node);
            } else if (node instanceof Region) {
                tableRegions.add((Region) node);
            }
        }
        tableButtons.forEach(b -> b.setText("TABLE"));
        tableRegions.forEach(r -> r.setBackground(new Background(new BackgroundFill(ColorPalette.Blue500(), CornerRadii.EMPTY, Insets.EMPTY))));

        //Menu Tree Table Initialization
        menuColumn1.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        menuColumn2.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        menuColumn3.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        menuColumn4.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        menuItems.forEach(i -> tableMenu.getItems().add(i));

        System.out.println("Initialising the Main Scene");
    }

    public void tableButtonClicked(ActionEvent event) {
        System.out.println("BUTTON PRESSED");
    }
}
