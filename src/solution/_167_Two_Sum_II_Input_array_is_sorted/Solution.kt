package solution._167_Two_Sum_II_Input_array_is_sorted

/**
 * @author: sorcererxw
 * @date: 2019/4/1
 * @description:
 */
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = numbers[l] + numbers[r]
            when {
                sum < target -> l++
                sum > target -> r--
                sum == target -> {
                    return intArrayOf(l+1,r+1)
                }
            }
        }
        return intArrayOf()
    }
}