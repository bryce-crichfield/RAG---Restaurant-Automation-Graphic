package org.eleven;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.eleven.resource.SceneLoader;

public class Launcher extends Application {

    public final String LOGIN_SCENE = "login_scene_layout";
    public final String MAIN_SCENE = "main_scene_layout";


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Application Starting");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneLoader sceneLoader = SceneLoader.load_scene("login_scene_layout");
        Scene loginScene = sceneLoader.scene();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Automation Project - Login");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(563);
        primaryStage.show();

    }

    public void stop() throws Exception {
        System.out.println("Application Exited Successfully");
    }
}
