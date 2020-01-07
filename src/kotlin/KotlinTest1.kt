package src.kotlin

fun main(){
    val basic = Basic()
    println(basic.getName())

    println(basic.name)
}

//Extensions functions
fun Basic.getName() = "shape"

fun Any?.toString():String{
    if(this == null) return "null"
    return toString()
}

//Extension properties
val<T> List<T>.lastIndex: Int
    get() = size - 1

class Basic {
    var name: Int = 0
}