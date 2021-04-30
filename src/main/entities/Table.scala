package org.eleven
package entities

import entities.FloorManager.WIDTH
import entities.status.{ERROR_STATUS_ORDER, OrderStatus}


class Table(id: Int, var order: Order) {

    val x: Int = id % WIDTH
    val y: Int = id / WIDTH

    val status: OrderStatus = {
        if(order != null) order.status
        else ERROR_STATUS_ORDER
    }


}
