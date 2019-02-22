package solution._412_Fizz_Buzz

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/fizz-buzz/
 */
class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val list: MutableList<String> = ArrayList(n)
        for (i in 1..n) {
            list.add(when {
                i % 15 == 0 -> "FizzBuzz"
                i % 3 == 0 -> "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> i.toString()
            })
        }
        return list
    }
}