package _643_Maximum_Average_Subarray_I

/**
 * @author: SorcererXW
 * @date: 2018/5/21
 * @description:
 */

class Solution {
    companion object {
        const val MIN = -10001.0
    }

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val avg = DoubleArray(nums.size, { MIN })
        var max = MIN
        var sum = 0.0
        for (i in 0 until nums.size) {
            if (i < k - 1) {
                sum += nums[i]
                continue
            } else if (i == k - 1) {
                sum += nums[i]
                avg[i] = sum / k
                if (max < avg[i]) max = avg[i]
            } else {
                sum = sum + nums[i] - nums[i - k]
                avg[i] = sum / k
                if (max < avg[i]) max = avg[i]
            }
        }
        return max
    }
}

fun main(args: Array<String>) {
    println(Solution().findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
}
