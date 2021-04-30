package org.eleven
package entities

import org.eleven.entities.status.PLACED

import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer

object OrderManager {

    val TABLE_COUNT = 36
    val WIDTH = 6
    val HEIGHT = 6

    val tables: List[Table] = {
        (for (id <- 1 to 50)
            yield new Table(id, new Order(ListBuffer[Item](), id))).toList
    }

    private val queue = Queue[Order]()

    def submitOrder(order: Order): Unit = {
        order.setStatus(PLACED)
        val sameOrder = queue.filter(o => o.orderID == order.orderID)
        if(sameOrder.nonEmpty) {
            val idx = queue.indexOf(sameOrder.head)
            queue(idx) = order
        } else {
            queue.addOne(order)
        }
    }
    def getQueue(): Queue[Order] = queue
    def getTable(tableID: Int): Table = tables(tableID);
}
