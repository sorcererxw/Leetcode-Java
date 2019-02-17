package solution._240_Search_a_2D_Matrix_II

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/search-a-2d-matrix-ii/
 * O(m+n)
 * 先找到一个中间点，选右上角的点
 * 这样这一来，向左移动变小，向下移动变大
 * 这样子，只需要根据目标的大小，不断移动就好了，直到找到，或者无法继续移动
 */
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        val m = if (matrix.isNotEmpty()) matrix[0].size else -1
        if (n <= 0 || m <= 0) return false
        var x = 0
        var y = m - 1
        while (x < n && y >= 0) {
            if (matrix[x][y] == target) return true
            else if (matrix[x][y] > target) y--
            else if (matrix[x][y] < target) x++
        }
        return false
    }

}

fun main(args: Array<String>) {
    val testCast = arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
    )
    val result = Solution().searchMatrix(emptyArray(), 5)
    println(result)
}