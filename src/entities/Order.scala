package entities

import entities.status.{OrderStatus, UNPLACED}

import scala.collection.mutable.ListBuffer
import scala.util.Random

class Order(private var items: ListBuffer[Item],
            val tableid: Int,
            private var status: OrderStatus = UNPLACED) {
    val orderID = Random.between(0, 1000000)

    //String representations used to maintain compatibility with JFX TableView
    def statusString = status.ID

    def subTotalString = subtotal.toString

    def totalString = {
        val n = BigDecimal(subTotalString).setScale(2, BigDecimal.RoundingMode.HALF_UP)
        n.toDouble.toString
    }

    def subtotal: Double = items.map(_.itemPrice).sum

    def total(tax_rate: Double = 0.07): Double = {
        val total = subtotal + (subtotal * tax_rate)
        total - (total % 0.01)
    }

    def addItem(i: Item): Unit = items.append(i)

    def removeItem(i: Item): Unit = {
        val list = items.toList.filter(x => x != i)
        val buffer = new ListBuffer[Item]
        list.map(x => buffer.append(x))
        items = buffer
    }

    def getItems(): List[Item] = items.toList

    def getStatus = status

    def setStatus(s: OrderStatus) = status
}


