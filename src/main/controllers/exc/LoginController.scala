package org.eleven
package controllers

import resource.SceneLoader.load_scene
import resource.RequestHandler._
import scalafx.Includes._
import scalafx.scene.Scene
import javafx.fxml.FXML
import javafx.scene.control.{PasswordField, TextField}
import javafx.event.ActionEvent

class LoginController extends Controller {


    @FXML var username_field: TextField = _
    @FXML var password_field: PasswordField = _

    def loginButtonClicked: Unit = {
        if(validateInput == false) return
        val new_root = load_scene("main_floor_layout").parent
        val new_scene = new Scene()
        new_scene.setRoot(new_root)
        Launcher.stage.setScene(new_scene)
        stage.setTitle("main_floor_layout")
    }

    //can be used to also set current user
    def validateInput: Boolean = {
        val u = username_field.getText
        val p = password_field.getText
        val valid_user = validate_user(u, p)
        if(valid_user.isDefined) true else false
    }

    def onButtonClick(event: ActionEvent) = println(event.getSource)

}
