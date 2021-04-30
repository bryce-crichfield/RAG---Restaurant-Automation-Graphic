package org.eleven
package entities

import entities.status.{OrderStatus, PLACED}

import scala.collection.mutable.ListBuffer
import java.util
import java.util.UUID
import scala.util.Random

class Order(private var items: ListBuffer[Item],
            val tableid: Int,
            var seat_num: Int = 0,
            var status: OrderStatus = PLACED)
    {

    //String representations used to maintain compatibility with JFX TableView
    val statusString = status.ID
    val subTotalString = subtotal.toString
    val totalString = total().toString

    val orderID = Random.between(0,1000000)
    def subtotal: Double = items.map(_.itemPrice).sum
    def total(tax_rate: Double = 0.07): Double = subtotal + (subtotal*tax_rate)

    def addItem(i: Item): Unit = items.append(i)
    def removeItem(i:Item): Unit = {
        val list = items.toList.filter(x => x != i)
        val buffer = new ListBuffer[Item]
        list.map(x => buffer.append(x))
        items = buffer
    }
    def getItems(): List[Item] = items.toList
}


