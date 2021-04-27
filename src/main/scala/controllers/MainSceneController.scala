package org.eleven
package controllers

import Launcher.stage

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.layout.Region
import org.eleven.resource_io.Loaded_Scene.load_scene
import scalafx.scene.Scene

class MainSceneController extends Controller {

    //Sub Grid 1:
    @FXML var t_grid_g1_b1: Button = _
    @FXML var t_grid_g1_b2: Button = _
    @FXML var t_grid_g1_b3: Button = _
    @FXML var t_grid_g1_b4: Button = _
    @FXML var t_grid_g1_r1: Region = _
    @FXML var t_grid_g1_r2: Region = _
    @FXML var t_grid_g1_r3: Region = _
    @FXML var t_grid_g1_r4: Region = _
    //Sub Grid 2:
    @FXML var t_grid_g2_b1: Button = _
    @FXML var t_grid_g2_b2: Button = _
    @FXML var t_grid_g2_b3: Button = _
    @FXML var t_grid_g2_b4: Button = _
    @FXML var t_grid_g2_r1: Region = _
    @FXML var t_grid_g2_r2: Region = _
    @FXML var t_grid_g2_r3: Region = _
    @FXML var t_grid_g2_r4: Region = _
    //Sub Grid 3:
    @FXML var t_grid_g3_b1: Button = _
    @FXML var t_grid_g3_b2: Button = _
    @FXML var t_grid_g3_b3: Button = _
    @FXML var t_grid_g3_b4: Button = _
    @FXML var t_grid_g3_r1: Region = _
    @FXML var t_grid_g3_r2: Region = _
    @FXML var t_grid_g3_r3: Region = _
    @FXML var t_grid_g3_r4: Region = _
    //Sub Grid 4:
    @FXML var t_grid_g4_b1: Button = _
    @FXML var t_grid_g4_b2: Button = _
    @FXML var t_grid_g4_b3: Button = _
    @FXML var t_grid_g4_b4: Button = _
    @FXML var t_grid_g4_r1: Region = _
    @FXML var t_grid_g4_r2: Region = _
    @FXML var t_grid_g4_r3: Region = _
    @FXML var t_grid_g4_r4: Region = _
    //Sub Grid 5:
    @FXML var t_grid_g5_b1: Button = _
    @FXML var t_grid_g5_b2: Button = _
    @FXML var t_grid_g5_b3: Button = _
    @FXML var t_grid_g5_b4: Button = _
    @FXML var t_grid_g5_r1: Region = _
    @FXML var t_grid_g5_r2: Region = _
    @FXML var t_grid_g5_r3: Region = _
    @FXML var t_grid_g5_r4: Region = _
    //Sub Grid 6:
    @FXML var t_grid_g6_b1: Button = _
    @FXML var t_grid_g6_b2: Button = _
    @FXML var t_grid_g6_b3: Button = _
    @FXML var t_grid_g6_b4: Button = _
    @FXML var t_grid_g6_r1: Region = _
    @FXML var t_grid_g6_r2: Region = _
    @FXML var t_grid_g6_r3: Region = _
    @FXML var t_grid_g6_r4: Region = _
    //Sub Grid 7:
    @FXML var t_grid_g7_b1: Button = _
    @FXML var t_grid_g7_b2: Button = _
    @FXML var t_grid_g7_b3: Button = _
    @FXML var t_grid_g7_b4: Button = _
    @FXML var t_grid_g7_r1: Region = _
    @FXML var t_grid_g7_r2: Region = _
    @FXML var t_grid_g7_r3: Region = _
    @FXML var t_grid_g7_r4: Region = _
    //Sub Grid 8:
    @FXML var t_grid_g8_b1: Button = _
    @FXML var t_grid_g8_b2: Button = _
    @FXML var t_grid_g8_b3: Button = _
    @FXML var t_grid_g8_b4: Button = _
    @FXML var t_grid_g8_r1: Region = _
    @FXML var t_grid_g8_r2: Region = _
    @FXML var t_grid_g8_r3: Region = _
    @FXML var t_grid_g8_r4: Region = _
    //Sub Grid 9:
    @FXML var t_grid_g9_b1: Button = _
    @FXML var t_grid_g9_b2: Button = _
    @FXML var t_grid_g9_b3: Button = _
    @FXML var t_grid_g9_b4: Button = _
    @FXML var t_grid_g9_r1: Region = _
    @FXML var t_grid_g9_r2: Region = _
    @FXML var t_grid_g9_r3: Region = _
    @FXML var t_grid_g9_r4: Region = _




    def logOutButtonClicked: Unit = {
        val new_root = load_scene("login_scene_layout").parent
        val new_scene = new Scene()
        new_scene.setRoot(new_root)
        stage.setScene(new_scene)
        stage.setTitle("login_scene_layout")
    }

}
