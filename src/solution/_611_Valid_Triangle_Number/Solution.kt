package solution._611_Valid_Triangle_Number

import util.println

/**
 * @author: sorcererxw
 * @date: 2019/4/4
 * @description:
 */
class Solution {
    fun triangleNumber(nums: IntArray): Int {
        if (nums.size < 3) return 0
        var l = 0
        var r = 2
        var sum = 0
        nums.sort()
        // 线性查找
        for (i in 0 until nums.size - 2) {
            if (nums[i] == 0) continue
            var k = i + 2 // k 在一轮循环后不需要从回滚，因为 k 已经走过的元素，必然已经被考虑过了
            for (j in i + 1 until nums.size - 1) {
                while (k < nums.size && nums[i] + nums[j] > nums[k]) k++
                sum += k - j - 1 // 因为当前 k 逾出界限了，所以要减去一
            }
        }
        return sum
    }
}

fun main() {
    Solution().triangleNumber(intArrayOf(2, 2, 3, 4)).println()
    Solution().triangleNumber(intArrayOf(1, 2, 3, 4, 5, 6)).println()

}

/*
2,3,4
2,4,5
2,4,6
3,4,5
3,4,6
3,5,6
4,5,6
 */