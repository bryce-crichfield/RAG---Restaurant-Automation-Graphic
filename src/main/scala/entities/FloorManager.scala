package org.eleven
package entities

object FloorManager {

    val TABLE_COUNT = 36
    val WIDTH = 6
    val HEIGHT = 6

    val tables: List[Table] = (for (id <- 0 until 36) yield Table(id, None)).toList

}
