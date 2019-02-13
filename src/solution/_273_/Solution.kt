package solution._273_

/**
 * @author: sorcererxw
 * @date: 1/21/2019
 * @description:
 */
class Solution {
    companion object {
        val dictionary: Map<Int, String> = mapOf(
                0 to "Zero", 1 to "One", 2 to "Two", 3 to "Three", 4 to "Four",
                5 to "Five", 6 to "Six", 7 to "Seven", 8 to "Eight", 9 to "Nine",
                10 to "Ten", 11 to "Eleven", 12 to "Twelve", 13 to "Thirteen", 14 to "Fourteen",
                15 to "Fifteen", 16 to "Sixteen", 17 to "Seventeen", 18 to "Eighteen", 19 to "Nineteen",
                20 to "Twenty", 30 to "Thirty", 40 to "Forty", 50 to "Fifty",
                60 to "Sixty", 70 to "Seventy", 80 to "Eighty", 90 to "Ninety",
                100 to "Hundred",
                10e3.toInt() to "Thousand", 10e6.toInt() to "Million", 10e9.toInt() to "Billion"
        )

        val suffix = listOf(
                "", dictionary[10e3.toInt()], dictionary[10e6.toInt()], dictionary[10e9.toInt()]
        )
    }

    private fun getDecadeWord(num: Int): String {
        if (num <= 20) return dictionary[num]!!
        if (num < 100 && num % 10 == 0) return dictionary[num]!!
        return dictionary[num / 10 * 10]!! + " " + dictionary[num % 10]
    }

    private fun getHundredWord(num: Int): String {
        if (num < 100) return getDecadeWord(num)
        val hundred = dictionary[num / 100] + " " + dictionary[100]
        if (num >= 100 && num % 100 == 0) return hundred
        return hundred + " " + getDecadeWord(num % 100)
    }

    fun numberToWords(source: Int): String {
        var num = source
        if (num == 0) return dictionary[0]!!
        var result = ""
        var flag = 0
        while (num > 0) {
            if (num % 1000 > 0) {
                var word = getHundredWord(num % 1000)
                val suffix = suffix[flag]!!
                if (suffix.isNotEmpty()) {
                    word = "$word $suffix"
                }
                result = if (result.isNotEmpty()) {
                    "$word $result"
                } else {
                    word
                }
            }
            flag++
            num /= 1000
        }
        return result
    }
}

fun main(args: Array<String>) {
    intArrayOf(
            0, 7, 13, 21, 45, 99, 100, 101, 110, 121, 200, 250, 999, 1000, 1010, 1001, 1000000, 1000000023
    ).forEach {
        println(it.toString() + ": " + Solution().numberToWords(it))
    }
}