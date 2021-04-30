package org.eleven
package entities

import argonaut.Argonaut.casecodec4
import argonaut.CodecJson

case class Item(itemID: Int, itemName: String, itemPrice: Double, itemType: String) {
    //These two fields allow for compatibility with the tableView in JFX
    val itemIDString: String = itemID.toString
    val itemPriceString: String = itemPrice.toString
}

object Item {
    implicit def UserCodeJson: CodecJson[Item] =
        casecodec4(Item.apply, Item.unapply)("itemID", "itemName", "itemPrice", "itemType")
}
