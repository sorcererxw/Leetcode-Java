package solution._73_Set_Matrix_Zeroes

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/set-matrix-zeroes/
 */

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty()) return
        val h = matrix.size
        val w = matrix[0].size

        var fillFirstRow = false
        var fillFirstColumn = false

        for (i in 0 until h) for (j in 0 until w)
            if (matrix[i][j] == 0) {
                if (i == 0) fillFirstRow = true
                if (j == 0) fillFirstColumn = true
                matrix[i][0] = 0
                matrix[0][j] = 0
            }


        for (i in 1 until h)
            if (matrix[i][0] == 0) for (j in 0 until w) matrix[i][j] = 0

        for (j in 1 until w)
            if (matrix[0][j] == 0) for (i in 0 until h) matrix[i][j] = 0


        if (fillFirstRow) for (j in 0 until w) matrix[0][j] = 0
        if (fillFirstColumn) for (i in 0 until h) matrix[i][0] = 0
    }
}

fun main(args: Array<String>) {

    arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
    ).apply {
        Solution().setZeroes(this)
        this.forEach { println(it.toList()) }
    }
    println()

    arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
    ).apply {
        Solution().setZeroes(this)
        this.forEach { println(it.toList()) }
    }


}
