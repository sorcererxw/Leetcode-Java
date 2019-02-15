package solution._448_Find_All_Numbers_Disappeared_in_an_Array

/**
 * @author: Sorcerer
 * @date: 2/15/2019
 * @description: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 每一个数字找到自己原来的有序位置，通过+n来进行标记，通过%n来消除标记的影响，最后哪些位置没有被标记就是不存在数字
 * 因为数组长度必然是n,出现的数字最小值为1，最大值为n
 */
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result: MutableList<Int> = ArrayList()
        val n = nums.size
        for (i in 0 until n) {
            nums[(nums[i] - 1) % n] += n
        }
        for (i in 0 until n) {
            if (nums[i] <= n) {
                result.add(i + 1)
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val result = Solution().findDisappearedNumbers(intArrayOf(5,1,2,4,4))
    println(result)
}