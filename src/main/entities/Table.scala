package org.eleven
package entities

import entities.FloorManager.WIDTH
import entities.status.{DIRTY, ERROR_STATUS_ORDER, ERROR_STATUS_TABLE, OCCUPIED, OPEN, OrderStatus, TableStatus}


class Table(id: Int, private var order: Order, private var status: TableStatus = OPEN) {

    val x: Int = id % WIDTH
    val y: Int = id / WIDTH

    def getStatus: TableStatus = status

    def nextStatus: TableStatus = status match {
        case OPEN => OCCUPIED
        case OCCUPIED => DIRTY
        case DIRTY => OPEN
        case _ => ERROR_STATUS_TABLE
    }

    def setStatus(s: TableStatus) = status = s

    def getOrder(): Order = order

}
