package solution._43_

/**
 * @author: Sorcerer
 * @date: 12/8/2018
 * @description:
 */
class Solution {
    fun multiply(num1: String, num2: String): String {
        val number1 = num1.reversed().map { it - '0' }.toIntArray()
        val number2 = num2.reversed().map { it - '0' }.toIntArray()
        val result = IntArray(number1.size + number2.size) { 0 }
        for (i in 0 until number1.size) {
            var flag = 0
            var j = 0
            while (j < number2.size) {
                val t = number1[i] * number2[j] + result[i + j] + flag
                result[i + j] = t % 10
                flag = t / 10
                j++
            }
            while (flag > 0) {
                result[i+(j++)] = flag % 10
                flag /= 10
            }
        }
        val s = result.map { (it + 48).toChar() }.reversed().joinToString(separator = "")
        for (i in 0 until s.length) if (s[i] != '0') return s.substring(i)
        return "0"
    }
}

fun main(args: Array<String>) {
    println(Solution().multiply("0", "456"))
}