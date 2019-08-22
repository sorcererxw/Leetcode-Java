package solution._228_Summary_Ranges

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result: MutableList<String> = ArrayList()
        if (nums.isEmpty()) return result
        var start = nums[0]
        var last = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] == last + 1) {
                last = nums[i]
            } else {
                if (start == last) {
                    result.add("$start")
                } else {
                    result.add("$start->$last")
                }
                start = nums[i]
                last = nums[i]
            }
        }
        if (start == last) {
            result.add("$start")
        } else {
            result.add("$start->$last")
        }
        return result
    }
}

fun main(args: Array<String>) {
    Solution().summaryRanges(intArrayOf(0)).forEach { println(it) }
    Solution().summaryRanges(intArrayOf(0, 1, 2)).forEach { println(it) }
    Solution().summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)).forEach { println(it) }
}
