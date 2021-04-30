package org.eleven
package entities

import resource.RequestHandler.{load_database, load_menu}

import java.util
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters.SeqHasAsJava

object Menu {

    private val items = load_menu.get
    val drink_types =  List("beverage_alcoholic_beer_tap",
                        "beverage_alcoholic_beer_bottle",
                        "beverage_alcoholic_wine",
                        "beverage_non_alcoholic")
    val entree_types = List("chicken/seafood", "dinner_entree")
    val entrees = items.filter(i => entree_types.contains(i.itemType))
    val drinks = items.filter(i => drink_types.contains(i.itemType))
    val lunch = items.filter(_.itemType == "lunch_entree")
    val salads = items.filter(_.itemType == "soups/salad")
    val appetizers = items.filter(_.itemType == "appetizer")
    val desserts = items.filter(_.itemType == "dessert")

    def getMenu(s: String) = s match {
        case "entrees" => entrees
        case "drinks" => drinks
        case "lunch" => lunch
        case "salads" => salads
        case "appetizers" => appetizers
        case "desserts" => desserts
    }


}
