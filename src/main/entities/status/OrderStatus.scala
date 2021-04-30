package org.eleven
package entities.status

import resource.ColorPalette._

import javafx.scene.paint.Color

trait Status {
    val color: Color

    def ID: String
}

trait OrderStatus extends Status

object OrderStatus {
    def OrderStatus(s: String): OrderStatus = s match {
        case "UNPLACED" => UNPLACED
        case "PLACED" => PLACED
        case "KITCHEN_ACCEPTED" => KITCHEN_ACCEPTED
        case "KITCHEN_COMPLETED" => KITCHEN_COMPLETED
        case "ORDER_DELIVERED" => ORDER_DELIVERED
        case "ORDER_COMPLETED" => ORDER_COMPLETED
        case _ => ERROR_STATUS_ORDER
    }
}

case object UNPLACED extends OrderStatus {
    val color: Color = Yellow100
    def ID: String = "UNPLACED"
}

case object PLACED extends OrderStatus {
    val color: Color = Yellow100

    def ID: String = "PLACED"
}

case object KITCHEN_ACCEPTED extends OrderStatus {
    val color: Color = Yellow300

    def ID: String = "KITCHEN_ACCEPTED"
}

case object KITCHEN_COMPLETED extends OrderStatus {
    val color: Color = Yellow500

    def ID: String = "KITCHEN_COMPLETED"
}

case object ORDER_DELIVERED extends OrderStatus {
    val color: Color = Green100

    def ID: String = "ORDER_DELIVERED"
}

case object ORDER_COMPLETED extends OrderStatus {
    val color: Color = Green300

    def ID: String = "ORDER_COMPLETED"
}

case object ERROR_STATUS_ORDER extends OrderStatus {
    val color: Color = Red300

    def ID: String = "ERROR_STATUS_ORDER"
}

trait TableStatus extends Status

object TableStatus {
    def TableStatus(s: String): TableStatus = s match {
        case "OPEN" => OPEN
        case "OCCUPIED" => OCCUPIED
        case "DIRTY" => DIRTY
        case _ => ERROR_STATUS_TABLE
    }
}

case object OPEN extends TableStatus {
    val color: Color = Green500

    def ID: String = "OPEN"
}

case object OCCUPIED extends TableStatus {
    val color: Color = Yellow500

    def ID: String = "OCCUPIED"
}

case object DIRTY extends TableStatus {
    val color: Color = Red500

    def ID: String = "DIRTY"
}

case object ERROR_STATUS_TABLE extends TableStatus {
    val color: Color = Red900

    def ID: String = "ERROR_STATUS_TABLE"
}


