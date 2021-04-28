package solution._220_Contains_Duplicate_III

import util.println
import java.util.*

class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        val tree = TreeSet<Int>()
        for (i in 0 until nums.size) {
            val floor = tree.floor(nums[i])
            val celling = tree.ceiling(nums[i])

//            println("${nums[i]} $floor $celling")
            if (
                    (floor != null && nums[i].toLong() - floor <= t)
                    || (celling != null && celling.toLong() - nums[i] <= t)
            ) {
                return true
            }
            tree.add(nums[i])
            if (i >= k) {
                tree.remove(nums[i - k])
            }
        }
        return false
    }
}


fun main() {
    Solution().containsNearbyAlmostDuplicate(intArrayOf(-1, 2147483647), 1, 2147483647)
    Solution().containsNearbyAlmostDuplicate(intArrayOf(3, 6, 0, 4), 2, 2).println()
    Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 2), 0, 1).println()
    Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 2, 3, 1), 3, 0).println()
    Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 0, 1, 1), 1, 2).println()
    Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3).println()
}
