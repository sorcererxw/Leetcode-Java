package solution._48_Rotate_Image

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/rotate-image/
 * @solve: [x]
 * 先沿反对角线翻折
 * 再沿垂直中线翻折
 */
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n/2) {
                val t = matrix[i][j]
                matrix[i][j] = matrix[i][n - 1 - j]
                matrix[i][n - 1 - j] = t
            }
        }

    }
}

fun main(args: Array<String>) {
    val testCase = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )
    Solution().rotate(testCase)
    testCase.forEach {
        println(it.toList())
    }
}