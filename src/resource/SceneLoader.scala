package resource

import controllers.Controller
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}

case class SceneLoader(scene: Scene, parent: Parent, controller: Controller)

object SceneLoader {

    def load_scene(scene_title: String): SceneLoader = {
        val resource = getClass.getResource(s"/sfx_layouts/$scene_title.fxml")
        val loader = new FXMLLoader(resource)
        val parent = loader.load[Parent]
        val scene = new Scene(parent)
        val controller = loader.getController[Controller]
        SceneLoader(scene, parent, controller)
    }

}
