package org.eleven
package controllers

import Launcher.stage
import org.eleven.resource_io.Loaded_Scene.load_scene

import javafx.fxml.FXML
import javafx.scene.control.{PasswordField, TextField}
import scalafx.scene.Scene
import org.eleven.resource_io.RequestHandler._

class LoginController extends Controller {


    @FXML var username_field: TextField = _
    @FXML var password_field: PasswordField = _

    def loginButtonClicked: Unit = {
        if(validateInput == false) return
        val new_root = load_scene("main_floor_layout").parent
        val new_scene = new Scene()
        new_scene.setRoot(new_root)
        stage.setScene(new_scene)
        stage.setTitle("main_floor_layout")
    }

    //can be used to also set current user
    def validateInput: Boolean = {
        val u = username_field.getText
        val p = password_field.getText
        val valid_user = validate_user(u, p)
        if(valid_user.isDefined) true else false
    }


}
