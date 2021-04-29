package org.eleven
package entities

import argonaut.Argonaut.casecodec4
import argonaut.CodecJson

case class Item(itemd: Int, name: String, price: Double, itemtype: String)

object Item {
    implicit def UserCodeJson: CodecJson[Item] =
        casecodec4(Item.apply, Item.unapply)("itemid", "name", "price", "itemtype")
}
