package src.kotlin.learning.basic

val PI = 3.14

fun main() {
    testWhen("test4", listOf("test", "test1", "test2"))
}

/**
 * 测试for循环
 * */
fun testForLoop(){
    val items = listOf(1,2,"apple")
    for (item in items){
        println(item)
    }
}



/**
 * when关键字包含switch关键字的功能
 *
 * */
fun testWhen(obj: Any?,items:List<String>):Unit {
    when (obj) {
        1 -> println("one")
        2 -> println("two")
        3 -> println("three")
        4 -> println("four")
        5 -> println("five")
        else -> println("unknown")
    }

    when (obj) {
        in items -> {
            println("find $obj in list")
        }
    }

}

fun testRange(x: Int): Unit {
    if (x in 1..5) {
        println("fits in range")
    }
}

fun sum(a: Int, b: Int) = a + b

fun sum():Unit {
    val a: Int = 1
    val b = 2
    val c: Int = 4

    print((c + PI).toInt())
}

fun testReplaceStr(a:String){
    print("name is : $a")
}

fun makeNewString(): String? {
    return "zy" + "name"
}

