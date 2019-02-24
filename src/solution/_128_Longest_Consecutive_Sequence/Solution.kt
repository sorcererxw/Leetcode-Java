package solution._128_Longest_Consecutive_Sequence

import util.println

/**
 * @author: Sorcerer
 * @date: 2/24/2019
 * @description: https://leetcode.com/problems/longest-consecutive-sequence/
 * 先把所有数据都压入 set 中
 * 然后可以把整体看作一个图，寻找最大的子图
 * 只需要可以在二维图里面操作一样
 * 找到一个点，只要存在，就向两边找，然后翻牌
 * 最后统计最大的即可
 */
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set: HashSet<Int> = HashSet()
        nums.forEach { set.add(it) }

        var max = 0

        for (num in nums) {
            if (!set.contains(num)) continue
            set.remove(num)
            var count = 1
            var x = num - 1
            while (set.contains(x)) {
                count++
                set.remove(x)
                x--
            }
            x = num + 1
            while (set.contains(x)) {
                count++
                set.remove(x)
                x++
            }
            if (count > max) max = count
        }
        return max
    }
}

fun main(args: Array<String>) {
    Solution().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)).println()
}