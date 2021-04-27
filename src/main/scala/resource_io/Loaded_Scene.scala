package org.eleven
package resource_io

import controllers.Controller

import javafx.fxml.FXMLLoader
import javafx.scene.Parent

case class Loaded_Scene(parent: Parent, controller: Controller)

object Loaded_Scene {

    def load_scene(scene_title: String): Loaded_Scene = {
        val resource = getClass.getResource(s"/sfx_layouts/$scene_title.fxml")
        val loader = new FXMLLoader(resource)
        val scene = loader.load[Parent]
        val controller = loader.getController[Controller]
        Loaded_Scene(scene, controller)
    }

}
