package org.eleven
package resource

import javafx.scene.Node

import scala.collection.mutable.ListBuffer
import javafx.scene.control.Button
import javafx.scene.layout.GridPane

import java.util

object TableGridExtractor {

    def extractButtons(grid: GridPane): util.ArrayList[Button] = {
        val list = ListBuffer[Node]()
        val children = grid.getChildren.forEach(c => list.addOne(c))
        val buttons = list.filter(n => n.isInstanceOf[Button]).map(_.asInstanceOf[Button]).toList
        buttons.asInstanceOf[util.ArrayList[Button]]
    }

}
