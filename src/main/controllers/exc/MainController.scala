//package org.eleven
//package controllers
//
//import entities.FloorManager
//import entities.status._
//import resource_io.SceneLoader.load_scene
//
//import javafx.event.ActionEvent
//import javafx.fxml.FXML
//import javafx.geometry.Insets
//import javafx.scene.control.Button
//import javafx.scene.layout.{Background, BackgroundFill, Region}
//import javafx.scene.paint.Color
//import scalafx.scene.Scene
//import scalafx.scene.layout.CornerRadii
//import COLOR_PALLETE._
//import MainSceneController._
//import scala.beans.BeanProperty
//import scala.util.{Failure, Success, Try}
//import scala.util.matching.Regex
//
//class MainSceneController extends Controller {
//
//
//    def onButtonClick(event: ActionEvent) = {
//        val source = event.getSource.asInstanceOf[Button]
//        val fxmlID = source.getId.mkString
//        val tableID = parseID(fxmlID)
//        val table = FloorManager.table(tableID)
//        val region = getRegion(tableID).getId
//        if(table.status != ERROR_STATUS_ORDER) println("region")
//        else println(ERROR_STATUS_ORDER)
//    }
//
//    def changeRegionColor(region: Region, color: Color): Unit = {
//        region.setBackground(new Background(new BackgroundFill(
//            color, CornerRadii.Empty, Insets.EMPTY)))
//    }
//
//
//
//    def parseID(fxmlID: String): Int = {
//        val pattern = new Regex("[0-9]+")
//        val matches = pattern findFirstIn fxmlID
//        val x = 1254
//        matches.get.toInt
//    }
//
//
//    def logOutButtonClicked: Unit = {
//        val new_root = load_scene("login_scene_layout").parent
//        val new_scene = new Scene()
//        new_scene.setRoot(new_root)
//        stage.setScene(new_scene)
//        stage.setTitle("login_scene_layout")
//    }
//
//    def gridSpaceClicked: Unit = {
//
//    }
//
//}
//
//object MainSceneController {
//
//    def getRegion(id: Int): Region =  {
//        this.getClass.getMethod(s"table_grid_r$id").invoke(this).asInstanceOf[Region]
//    }
//
//    def getButton(id: Int): Try[Button] = Try {
//        this.getClass.getMethod(s"table_grid_b$id").invoke(this).asInstanceOf[Button]
//    }
//
//    //TABLE GRID BUTTONS - DECLARATION:
//    @BeanProperty @FXML var table_grid_b1: Button = _
//    @BeanProperty @FXML var table_grid_b2: Button = _
//    @BeanProperty @FXML var table_grid_b3: Button = _
//    @BeanProperty @FXML var table_grid_b4: Button = _
//    @BeanProperty @FXML var table_grid_b5: Button = _
//    @BeanProperty @FXML var table_grid_b6: Button = _
//    @BeanProperty @FXML var table_grid_b7: Button = _
//    @BeanProperty @FXML var table_grid_b8: Button = _
//    @BeanProperty @FXML var table_grid_b9: Button = _
//    @BeanProperty @FXML var table_grid_b10: Button = _
//    @BeanProperty @FXML var table_grid_b11: Button = _
//    @BeanProperty @FXML var table_grid_b12: Button = _
//    @BeanProperty @FXML var table_grid_b13: Button = _
//    @BeanProperty @FXML var table_grid_b14: Button = _
//    @BeanProperty @FXML var table_grid_b15: Button = _
//    @BeanProperty @FXML var table_grid_b16: Button = _
//    @BeanProperty @FXML var table_grid_b17: Button = _
//    @BeanProperty @FXML var table_grid_b18: Button = _
//    @BeanProperty @FXML var table_grid_b19: Button = _
//    @BeanProperty @FXML var table_grid_b20: Button = _
//    @BeanProperty @FXML var table_grid_b21: Button = _
//    @BeanProperty @FXML var table_grid_b22: Button = _
//    @BeanProperty @FXML var table_grid_b23: Button = _
//    @BeanProperty @FXML var table_grid_b24: Button = _
//    @BeanProperty @FXML var table_grid_b25: Button = _
//    @BeanProperty @FXML var table_grid_b26: Button = _
//    @BeanProperty @FXML var table_grid_b27: Button = _
//    @BeanProperty @FXML var table_grid_b28: Button = _
//    @BeanProperty @FXML var table_grid_b29: Button = _
//    @BeanProperty @FXML var table_grid_b30: Button = _
//    @BeanProperty @FXML var table_grid_b31: Button = _
//    @BeanProperty @FXML var table_grid_b32: Button = _
//    @BeanProperty @FXML var table_grid_b33: Button = _
//    @BeanProperty @FXML var table_grid_b34: Button = _
//    @BeanProperty @FXML var table_grid_b35: Button = _
//    @BeanProperty @FXML var table_grid_b36: Button = _
//    //TABLE GRID REGIONS - DECLARATION:
//    @BeanProperty @FXML var table_grid_r1: Region = _
//    @BeanProperty @FXML var table_grid_r2: Region = _
//    @BeanProperty @FXML var table_grid_r3: Region = _
//    @BeanProperty @FXML var table_grid_r4: Region = _
//    @BeanProperty @FXML var table_grid_r5: Region = _
//    @BeanProperty @FXML var table_grid_r6: Region = _
//    @BeanProperty @FXML var table_grid_r7: Region = _
//    @BeanProperty @FXML var table_grid_r8: Region = _
//    @BeanProperty @FXML var table_grid_r9: Region = _
//    @BeanProperty @FXML var table_grid_r10: Region = _
//    @BeanProperty @FXML var table_grid_r11: Region = _
//    @BeanProperty @FXML var table_grid_r12: Region = _
//    @BeanProperty @FXML var table_grid_r13: Region = _
//    @BeanProperty @FXML var table_grid_r14: Region = _
//    @BeanProperty @FXML var table_grid_r15: Region = _
//    @BeanProperty @FXML var table_grid_r16: Region = _
//    @BeanProperty @FXML var table_grid_r17: Region = _
//    @BeanProperty @FXML var table_grid_r18: Region = _
//    @BeanProperty @FXML var table_grid_r19: Region = _
//    @BeanProperty @FXML var table_grid_r20: Region = _
//    @BeanProperty @FXML var table_grid_r21: Region = _
//    @BeanProperty @FXML var table_grid_r22: Region = _
//    @BeanProperty @FXML var table_grid_r23: Region = _
//    @BeanProperty @FXML var table_grid_r24: Region = _
//    @BeanProperty @FXML var table_grid_r25: Region = _
//    @BeanProperty @FXML var table_grid_r26: Region = _
//    @BeanProperty @FXML var table_grid_r27: Region = _
//    @BeanProperty @FXML var table_grid_r28: Region = _
//    @BeanProperty @FXML var table_grid_r29: Region = _
//    @BeanProperty @FXML var table_grid_r30: Region = _
//    @BeanProperty @FXML var table_grid_r31: Region = _
//    @BeanProperty @FXML var table_grid_r32: Region = _
//    @BeanProperty @FXML var table_grid_r33: Region = _
//    @BeanProperty @FXML var table_grid_r34: Region = _
//    @BeanProperty @FXML var table_grid_r35: Region = _
//    @BeanProperty @FXML var table_grid_r36: Region = _
//
//    private def get(name: String): AnyRef = this.getClass.getDeclaredField(name)
////
////
////
////    val tablegrid_buttons: Map[String, Button] = Map(
////        "table_grid_b1" -> get("table_grid_b1").asInstanceOf[Button],
////        "table_grid_b2" -> get("table_grid_b2").asInstanceOf[Button],
////        "table_grid_b3" -> get("table_grid_b3").asInstanceOf[Button],
////        "table_grid_b4" -> get("table_grid_b4").asInstanceOf[Button],
////        "table_grid_b5" -> get("table_grid_b5").asInstanceOf[Button],
////        "table_grid_b6" -> get("table_grid_b6").asInstanceOf[Button],
////        "table_grid_b7" -> get("table_grid_b7").asInstanceOf[Button],
////        "table_grid_b8" -> get("table_grid_b8").asInstanceOf[Button],
////        "table_grid_b9" -> get("table_grid_b9").asInstanceOf[Button],
////        "table_grid_b10" -> get("table_grid_b10").asInstanceOf[Button],
////        "table_grid_b11" -> get("table_grid_b11").asInstanceOf[Button],
////        "table_grid_b12" -> get("table_grid_b12").asInstanceOf[Button],
////        "table_grid_b13" -> get("table_grid_b13").asInstanceOf[Button],
////        "table_grid_b14" -> get("table_grid_b14").asInstanceOf[Button],
////        "table_grid_b15" -> get("table_grid_b15").asInstanceOf[Button],
////        "table_grid_b16" -> get("table_grid_b16").asInstanceOf[Button],
////        "table_grid_b17" -> get("table_grid_b17").asInstanceOf[Button],
////        "table_grid_b18" -> get("table_grid_b18").asInstanceOf[Button],
////        "table_grid_b19" -> get("table_grid_b19").asInstanceOf[Button],
////        "table_grid_b20" -> get("table_grid_b20").asInstanceOf[Button],
////        "table_grid_b21" -> get("table_grid_b21").asInstanceOf[Button],
////        "table_grid_b22" -> get("table_grid_b22").asInstanceOf[Button],
////        "table_grid_b23" -> get("table_grid_b23").asInstanceOf[Button],
////        "table_grid_b24" -> get("table_grid_b24").asInstanceOf[Button],
////        "table_grid_b25" -> get("table_grid_b25").asInstanceOf[Button],
////        "table_grid_b26" -> get("table_grid_b26").asInstanceOf[Button],
////        "table_grid_b27" -> get("table_grid_b27").asInstanceOf[Button],
////        "table_grid_b28" -> get("table_grid_b28").asInstanceOf[Button],
////        "table_grid_b29" -> get("table_grid_b29").asInstanceOf[Button],
////        "table_grid_b30" -> get("table_grid_b30").asInstanceOf[Button],
////        "table_grid_b31" -> get("table_grid_b31").asInstanceOf[Button],
////        "table_grid_b32" -> get("table_grid_b32").asInstanceOf[Button],
////        "table_grid_b33" -> get("table_grid_b33").asInstanceOf[Button],
////        "table_grid_b34" -> get("table_grid_b34").asInstanceOf[Button],
////        "table_grid_b35" -> get("table_grid_b35").asInstanceOf[Button],
////        "table_grid_b36" -> get("table_grid_b36").asInstanceOf[Button]
////    )
////    val tablegrid_regions: List[Region] = List(
////        table_grid_r1,
////        table_grid_r2,
////        table_grid_r3,
////        table_grid_r4,
////        table_grid_r5,
////        table_grid_r6,
////        table_grid_r7,
////        table_grid_r8,
////        table_grid_r9,
////        table_grid_r10,
////        table_grid_r11,
////        table_grid_r12,
////        table_grid_r13,
////        table_grid_r14,
////        table_grid_r15,
////        table_grid_r16,
////        table_grid_r17,
////        table_grid_r18,
////        table_grid_r19,
////        table_grid_r20,
////        table_grid_r21,
////        table_grid_r22,
////        table_grid_r23,
////        table_grid_r24,
////        table_grid_r25,
////        table_grid_r26,
////        table_grid_r27,
////        table_grid_r28,
////        table_grid_r29,
////        table_grid_r30,
////        table_grid_r31,
////        table_grid_r32,
////        table_grid_r33,
////        table_grid_r34,
////        table_grid_r35,
////        table_grid_r36
////    )
//}
//
//
