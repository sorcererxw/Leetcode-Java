package solution._289_

/**
 * @author: Sorcerer
 * @date: 12/7/2018
 * @description:
 */
class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val result = Array(board.size) { Array(board[0].size) { 0 } }
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                var cnt = 0
                if (i > 0 && board[i - 1][j] == 1) cnt++
                if (j > 0 && board[i][j - 1] == 1) cnt++
                if (i < board.size - 1 && board[i + 1][j] == 1) cnt++
                if (j < board[i].size - 1 && board[i][j + 1] == 1) cnt++

                if (i > 0 && j > 0 && board[i - 1][j - 1] == 1) cnt++
                if (i > 0 && j < board[i].size - 1 && board[i - 1][j + 1] == 1) cnt++
                if (i < board.size - 1 && j > 0 && board[i + 1][j - 1] == 1) cnt++
                if (i < board.size - 1 && j < board[i].size - 1 && board[i + 1][j + 1] == 1) cnt++

                result[i][j] = if (board[i][j] == 1 && cnt < 2) 0
                else if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) 1
                else if (board[i][j] == 1 && cnt > 3) 0
                else if (board[i][j] == 0 && cnt == 3) 1
                else board[i][j]
            }
        }
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                board[i][j] = result[i][j]
            }
        }
    }
}

fun main(args: Array<String>) {
    val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
    )
    Solution().gameOfLife(board)
    board.forEach {
        it.forEach { print("$it ") }
        println()
    }
}