package solution._371_

/**
 * @author: Sorcerer
 * @date: 12/10/2018
 * @description:
 */
class Solution {
    fun getSum(a: Int, b: Int): Int {
        return if (a and b == 0) a xor b
        else getSum(a and b shl 1, a xor b)
    }
}