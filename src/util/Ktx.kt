package util

/**
 * @author: Sorcerer
 * @date: 2/21/2019
 * @description:
 */
fun Int.println() {
    println(this)
}

fun Boolean.println() {
    println(this)
}


fun Array<BooleanArray>.println() {
    this.forEach {
        println(it.map { if (it) 1 else 0 })
    }
}

fun Array<CharArray>.println() {
    this.forEach {
        println(it.toList())
    }
}


fun Array<IntArray>.println() {
    this.forEach {
        println(it.toList())
    }
}

fun IntArray.println() {
    println(this.toList().toString())
}