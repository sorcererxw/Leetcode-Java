package solution._542_

import kotlin.math.min

/**
 * @author: Sorcerer
 * @date: 12/4/2018
 * @description:
 */
class Solution {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val max:Int = 10005
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                if (matrix[i][j] == 0) continue
                matrix[i][j] = max
                val top = if (i > 0) matrix[i - 1][j] else -1
                val left = if (j > 0) matrix[i][j - 1] else -1
                if (i == 0 && j == 0) {
                    matrix[i][j] = matrix[i][j]
                } else if (i == 0) {
                    matrix[i][j] = min(left + 1, matrix[i][j])
                } else if (j == 0) {
                    matrix[i][j] = min(top + 1, matrix[i][j])
                } else {
                    matrix[i][j] = min(min(top, left) + 1, matrix[i][j])
                }
            }
        }
        for (i in matrix.size - 1 downTo 0) {
            for (j in matrix[i].size - 1 downTo 0) {
                if (matrix[i][j] == 0) continue
                val bottom = if (i < matrix.size - 1) matrix[i + 1][j] else -1
                val right = if (j < matrix[i].size - 1) matrix[i][j + 1] else -1
                if (i == matrix.size - 1 && j == matrix[i].size - 1) {
                    matrix[i][j] = matrix[i][j]
                } else if (i == matrix.size - 1) {
                    matrix[i][j] = min(right + 1, matrix[i][j])
                } else if (j == matrix[i].size - 1) {
                    matrix[i][j] = min(bottom + 1, matrix[i][j])
                } else {
                    matrix[i][j] = min(min(bottom, right) + 1, matrix[i][j])
                }
            }
        }
        return matrix
    }
}

fun main(args: Array<String>) {
    Solution().updateMatrix(
            arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 0),
                    intArrayOf(1, 1, 1)
            )
    ).forEach { row ->
        row.forEach { cell -> print("$cell ") }
        println()
    }
}