package org.eleven
package entities

import entities.Order.unique_id
import entities.status.{OrderStatus, PLACED}

import scala.util.Random

case class Order(items: List[Item],
                 id: Int = unique_id,
                 tableid: Int,
                 seat_num: Int = 0,
                 status: OrderStatus = PLACED)
{

    val subtotal = items.map(_.itemPrice.toInt).sum
    def total(tax_rate: Double = 0.07): Double = subtotal + (subtotal*tax_rate)
    def change_status(s: OrderStatus): Order = Order(items, id, tableid, seat_num, s)

}

object Order {


    //Not Really unique, but developing a hash algo and order manager takes more work
    def unique_id = Random.nextInt()
}

