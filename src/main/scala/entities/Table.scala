package org.eleven
package entities

import FloorManager.WIDTH


case class Table(id: Int, order: Option[Order]) {

    val x: Int = id % WIDTH
    val y: Int = id / WIDTH

}
