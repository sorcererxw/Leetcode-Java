package solution._238_Product_of_Array_Except_Self

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/product-of-array-except-self/
 * 每个位置的答案都是 左侧所有数字*右侧所有数字
 * 只需要从左到右遍历，每次到一个位置，把 k 赋给当前位置的答案，通过 k 乘上所到数字
 * 从左到右，从右到左个来一遍，就能得出答案
 */
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        var k = 1
        for (i in 0 until nums.size) {
            result[i] *= k
            k *= nums[i]
        }

        k = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= k
            k *= nums[i]
        }

        return result
    }
}