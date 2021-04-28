import java.util.*

/**
 * @author: Sorcerer
 * @date: 11/1/2018
 * @description:
 */
class _12_Integer_to_Roman {
    private val romans = arrayOf(
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    )
    private val nums = arrayOf(
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    )

    fun intToRoman(num: Int): String {
        var rest = num
        val builder = StringBuilder()
        for (i in 0 until romans.size) {
            if (nums[i] <= rest) {
                val cnt = rest / nums[i]
                rest -= cnt * nums[i]
                for (j in 0 until cnt) builder.append(romans[i])
            }
        }
        return builder.toString()
    }
}

fun main(args: Array<String>) {
    var question = 1
    while (question <= 3999) {
        println("$question: " + _12_Integer_to_Roman().intToRoman(question))
        question += Random().nextInt(20)
    }
}
