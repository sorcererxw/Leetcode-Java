package solution._560_Subarray_Sum_Equals_K

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/subarray-sum-equals-k/
 * 类似于 dp 保存之前的状态
 * 但是因为下标无无序，而且存在负数，转而使用 map 进行保存
 */
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map: MutableMap<Int, Int> = HashMap()

        var count = 0
        var sum = 0

        map[0] = 1

        for (i in 0 until nums.size) {
            sum += nums[i]
            if (map.containsKey(sum - k)) {
                count += map[sum - k]!!
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1)
        }

        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().subarraySum(intArrayOf(1, 1, 1), 2))
}