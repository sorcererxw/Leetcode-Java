package solution._137_Single_Number_II

import util.println

/**
 * @author: sorcererxw
 * @date: 3/4/2019
 * @description: https://leetcode.com/problems/single-number-ii/
 * 把数字拆成二进制，因为对于一个数字的某一位，一定是1 or 0，那么三个相加也一定是 3 or 0
 * 只要对3取余就能消除掉，剩下的就是那个落单的，剩下的可以是 1 or 0
 */
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in 0 until 32) {
            var sum = 0
            for (j in 0 until nums.size) {
                if (((nums[j] shr i) and 1) == 1) {
                    sum += 1
                }
            }
            sum %= 3
            result = (sum shl i) or result
        }
        return result
    }
}

fun main() {
    Solution().singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)).println()
}