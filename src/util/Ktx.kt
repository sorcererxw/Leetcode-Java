package util

/**
 * @author: Sorcerer
 * @date: 2/21/2019
 * @description:
 */
fun Int.println() {
    println(this)
}

fun IntArray.println(){
    println(this.toList().toString())
}