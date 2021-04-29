package org.eleven
package entities

import resource.RequestHandler.load_menu

import java.util
import scala.collection.mutable.ListBuffer
import scala.collection.JavaConverters.bufferAsJavaListConverter
import scala.collection.mutable.ArrayBuffer

object Menu {

    //No error handling
    val items = {
        if(load_menu.isDefined) {
            load_menu.get.toBuffer.asJava.asInstanceOf[util.ArrayList[Item]]
        } else {
           ListBuffer[Item](Item("10000", "PHONY", "sdghdg", "hsdjkg")).asJava
        }
    }


    //No error handling in the case that two items share the same ID, which shouldn't happen but still..
//    def select_item(id: Int): Item = {
//        items.filter(i => i.itemd == id).head
//    }

}
