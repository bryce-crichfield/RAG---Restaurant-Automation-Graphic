package org.eleven
package resource_io

import user.User

import argonaut.{Json, Parse}

object RequestHandler {

    def validate_user(username: String, password: String): Option[User] = {
        val table = load_database("USERS")
        if (table.isEmpty) return None
        else {
            val received = table.get
            val decoded = Parse.decodeOption[List[User]](received.toString())
            if (decoded.isEmpty) return None
            val valid = (u: User) => u.username == username && u.password == password
            val exists = decoded.get.exists(valid)
            if (exists) return Some(decoded.get.filter(valid).head)
        }
        None
    }


    def load_database(db_name: String): Option[Json] = {
        val resource = getClass.getResource(s"/database_tables/$db_name.json")
        val source = scala.io.Source.fromFile(resource.toURI).mkString
        val parsed: Option[Json] = Parse.parseOption(source)
        parsed
    }

}
