package org.eleven
package user

import argonaut.Argonaut.casecodec8
import argonaut.CodecJson

case class User(userid: Int, user_type: String, username: String,
                password: String, firstname: String, lastname: String,
                address: String, zipcode: Int) {
}
object User {
    implicit def UserCodeJson: CodecJson[User] =
        casecodec8(User.apply, User.unapply)("userid", "user_type", "username", "password", "firstname", "lastname", "address", "zipcode")

}
