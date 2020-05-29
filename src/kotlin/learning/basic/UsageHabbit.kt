package src.kotlin.learning.basic

data class Customer(val name: String, val email: String)

fun main() {
//    val customer = Customer("zy", "zhaokidd521@gmail.com")
//
//    val items = listOf(1, 2, 3, 4, 5, 6)
//
//    val filteredItems = items.filter { x -> x > 2 }
//
//    println(filteredItems)
//
//    testTraversalLoop()
//
//
//    //test extension function
//    val text: String = "a"
//    println(text.spaceToCamelCase())
//
//    testIfNotNull()

    print(foo(1))
}

/**
 * 遍历元素
 * */
fun testTraversalLoop() {
    //每间隔两个元素
    for (x in 2..10 step 2) {
        print("$x,")
    }

    println()

    for (i in 1 until 100) {
        print("$i,")
    }

}

fun String.spaceToCamelCase(): String {
    val builder: StringBuilder = StringBuilder()

    for (item in this) {
        builder.append(item.toUpperCase())
    }

    return builder.toString()
}

fun testIfNotNull() {
    val value = ""

    value?.let {
        println("value is not null")
    }
}

fun testTryCatch() {
    val result = try {
    } catch (e: Exception) {

    }
}

fun foo(param: Int):String {
    val result = if (param == 1) {
        "One"
    } else if (param == 2) {
        "Two"
    } else {
        "Three"
    }

    return result
}

class Turtle{
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees:Double){}
    fun forward(pixels:Double){}
}

fun testWithKWord(){
    val myTurtle = Turtle()

    with(myTurtle){
        penDown()
        penUp()
    }
}