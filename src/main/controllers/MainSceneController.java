package org.eleven.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.eleven.Launcher;
import org.eleven.resource.ColorPalette;
import org.eleven.resource.SceneLoader;
import org.eleven.resource.TableGridExtractor;

import java.util.ArrayList;


public class MainSceneController implements Controller{

    @FXML MenuItem logOutButton;
    @FXML MenuBar menuBar;
    @FXML GridPane tableGrid;
    ArrayList<Button> tableButtons = TableGridExtractor.extractButtons(tableGrid);
    @FXML ArrayList<Region> tableRegions = new ArrayList<>();

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
        System.out.println("Initialising the Main Scene");
    }

    public void tableButtonClicked(ActionEvent event) {

    }
}
