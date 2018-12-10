package solution.__98_Random_Pick_Index

/**
 * @author: SorcererXW
 * @date: 2018/5/15
 * @description:
 */

class Solution(val nums: IntArray) {
    fun pick(target: Int): Int {
        var countdown = (Math.random() * nums.size).toInt()
        var idx = 0
        while (countdown >= 0) {
            if (nums[idx] == target) {
                if (countdown == 0) {
                    return idx
                } else {
                    countdown--
                }
            }
            idx++
            if (idx == nums.size) idx = 0
        }
        return idx
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.pick(target)
 */

fun main(args: Array<String>) {
    println(Solution(intArrayOf(1, 2, 3, 3, 3)).pick(3))
}
