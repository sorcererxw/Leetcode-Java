package solution._378_Kth_Smallest_Element_in_a_Sorted_Matrix

import util.println

/**
 * @author: Sorcerer
 * @date: 2/27/2019
 * @description: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.isEmpty()) return -1
        val height = matrix.size
        val width = matrix[0].size
        if (height == 0 || width == 0) return -1

        val row = if (k % width == 0) k / width else (k / width + 1)
        val column = if (k % width == 0) width else (k % width)
        return matrix[row - 1][column - 1]
    }
}

fun main(args: Array<String>) {
    Solution().kthSmallest(arrayOf(intArrayOf(-5)), 1).println()
    Solution().kthSmallest(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3)
    ), 2).println()

}