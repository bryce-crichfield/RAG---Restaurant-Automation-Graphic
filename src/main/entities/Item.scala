package org.eleven
package entities

import argonaut.Argonaut.casecodec4
import argonaut.CodecJson

case class Item(itemID: String, itemName: String, itemPrice: String, itemType: String)

object Item {
    implicit def UserCodeJson: CodecJson[Item] =
        casecodec4(Item.apply, Item.unapply)("itemID", "itemName", "itemPrice", "itemType")
}
