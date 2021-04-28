package solution._287_Find_the_Duplicate_Number

/**
 * @author: Sorcerer
 * @date: 2/14/2019
 * @description: https://leetcode.com/problems/find-the-duplicate-number/
 * 类似 #142, 也是找环
 * 如果 1-n 不重复，那么连成一个 list 就是一条链表
 * 如果出现重复，就意味着链表中有环，无法直接通过 i=[nums[i] 遍历整条链表
 * 那么通过这个特性，找到环入口即可
 */
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var fast = nums[0]
        var slow = nums[0]
        do {
            fast = nums[nums[fast]]
            slow = nums[slow]
        } while (fast != slow)

        var slow2 = nums[0]
        while (slow2 != slow) {
            slow = nums[slow]
            slow2 = nums[slow2]
        }
        return slow
    }
}

fun main(args: Array<String>) {
    val result = Solution().findDuplicate(intArrayOf(3,1,3,4,2))
    println(result)
}