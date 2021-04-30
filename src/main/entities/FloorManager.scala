package org.eleven
package entities

import scala.collection.mutable.ListBuffer

object FloorManager {

    val TABLE_COUNT = 36
    val WIDTH = 6
    val HEIGHT = 6

    val tables: List[Table] = {
        (for (id <- 1 to 36)
            yield new Table(id, new Order(ListBuffer[Item](), id))).toList
    }
    def getTable(tableID: Int): Table = tables(tableID);
}
