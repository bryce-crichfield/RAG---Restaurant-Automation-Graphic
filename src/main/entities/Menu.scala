package org.eleven
package entities

import resource.RequestHandler.{load_database, load_menu}

import java.util
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters.SeqHasAsJava

object Menu {

    //No error handling
    val items = load_menu.get


    //No error handling in the case that two items share the same ID, which shouldn't happen but still..
//    def select_item(id: Int): Item = {
//        items.filter(i => i.itemd == id).head
//    }

}
