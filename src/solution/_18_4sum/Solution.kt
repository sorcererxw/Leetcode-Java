package solution._18_4sum

/**
 * @author: Sorcerer
 * @date: 2/12/2019
 * @description: https://leetcode.com/problems/4sum/
 *  同 #15，循环内部加入适当剪枝
 */

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val arr = nums.sortedArray()
        val result: MutableList<List<Int>> = ArrayList()
        for (i in 0 until arr.size - 3) {
            if (i > 0 && arr[i] == arr[i - 1]) continue
            for (j in i + 1 until arr.size - 2) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue
                if (arr[i] + arr[j] + arr[j + 1] + arr[j + 2] > target) break
                if (arr[i] + arr[j] + arr[arr.size - 2] + arr[arr.size - 1] < target) continue
                var lo = j + 1
                var hi = arr.size - 1
                while (lo < hi) {
                    val sum = arr[i] + arr[j] + arr[lo] + arr[hi]
                    if (sum == target) {
                        result.add(listOf(arr[i], arr[j], arr[lo], arr[hi]))
                        while (lo < hi && arr[lo] == arr[lo + 1]) lo++
                        while (lo < hi && arr[hi] == arr[hi - 1]) hi--
                        lo++
                        hi--
                    } else if (sum > target) {
                        hi--
                    } else if (sum < target) {
                        lo++
                    }
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val result = Solution().fourSum(
            intArrayOf(1, 0, -1, 0, -2, 2),
            0
    )
    println(result)
}