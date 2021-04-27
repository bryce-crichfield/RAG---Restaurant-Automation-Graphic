package org.eleven
package controllers

import Launcher.stage
import org.eleven.resource_io.Loaded_Scene.load_scene

import scalafx.scene.Scene

class HomeSceneController extends Controller {

    def logOutButtonClicked: Unit = {
        val new_root = load_scene("login_scene_layout").parent
        val new_scene = new Scene()
        new_scene.setRoot(new_root)
        stage.setScene(new_scene)
        stage.setTitle("login_scene_layout")
    }

}
