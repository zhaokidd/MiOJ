package src.kotlin.codelabs

import com.sun.istack.internal.NotNull

data class User(@param:NotNull var firstName: String?, var lastName: String?)


fun main(){
    var user = User("yang","zhao")
    println(user.toString())
}