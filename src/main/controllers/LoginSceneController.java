package org.eleven.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.eleven.resource.RequestHandler;
import org.eleven.resource.SceneLoader;
import org.eleven.user.User;
import scala.Option;


public class LoginSceneController implements Controller {

    @FXML TextField username_field;
    @FXML PasswordField password_field;

    @Override
    public void initialize() {
        System.out.println("Initializing the Login Scene");
    }

    public void loginButtonClicked(ActionEvent event) {
        if(!validateInput()) return;
        SceneLoader sceneLoader = SceneLoader.load_scene("main_scene_layout");
        Scene homeScene = sceneLoader.scene();
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setTitle("Automation Project - Login");
        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    private boolean validateInput() {
        String u = username_field.getText();
        String p = password_field.getText();
        Option<User> existsValid = RequestHandler.validate_user(u,p);
        return existsValid.isDefined();
    }

}
