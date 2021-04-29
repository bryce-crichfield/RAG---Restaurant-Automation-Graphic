package org.eleven
package entities

import entities.FloorManager.WIDTH
import entities.status.{ERROR_STATUS_ORDER, OrderStatus}


case class Table(id: Int, order: Option[Order]) {

    val x: Int = id % WIDTH
    val y: Int = id / WIDTH

    val status: OrderStatus = {
        if(order.isDefined) order.get.status
        else ERROR_STATUS_ORDER
    }

}
