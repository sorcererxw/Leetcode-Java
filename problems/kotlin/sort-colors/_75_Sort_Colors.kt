package _75_Sort_Colors

/**
 * @author: SorcererXW
 * @date: 2018/5/17
 * @description:
 */

class Solution {

    fun sortColors(nums: IntArray): Unit {
        val cnt: IntArray = IntArray(3, { 0 })
        for (i in 0 until nums.size) cnt[nums[i]]++
        var now = 0
        var i = 0
        while (true) {
            if (i >= nums.size) break
            if (cnt[now] > 0) {
                nums[i] = now
                cnt[now]--
                i++
            } else {
                now++
            }
        }
    }
}


fun main(args: Array<String>) {

}
