package org.eleven
package entities

object FloorManager {

    val TABLE_COUNT = 36
    val WIDTH = 6
    val HEIGHT = 6

    private val tables: List[Table] = (for (id <- 1 to 36) yield Table(id, None)).toList


    def table(id: Int): Table = tables.filter(_.id == id).head


}
