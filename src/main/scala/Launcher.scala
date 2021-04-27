package org.eleven

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import org.eleven.resource_io.Loaded_Scene._
import org.eleven.resource_io.RequestHandler.{load_database, validate_user}

object Launcher extends JFXApp {

    //Init to LoginScreen
    val loaded_scene = load_scene("login_scene_layout")
    val root = loaded_scene.parent
    val controller = loaded_scene.controller

    stage = new PrimaryStage {
        title = "LoginScreen"
        scene = new Scene(root)
    }



}