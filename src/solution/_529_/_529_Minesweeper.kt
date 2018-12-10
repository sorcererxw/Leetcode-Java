package _529_Minesweeper

/**
 * @author: SorcererXW
 * @date: 2018/5/16
 * @description:
 */

class Solution {
    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val x = click[0]
        val y = click[1]
        if (board[x][y] == 'M') {
            board[x][y] = 'X'
            return board
        }

        return board
    }
}

fun main(args: Array<String>) {

    println(Solution().updateBoard(arrayOf(
            charArrayOf('E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'M', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E')
    ), intArrayOf(3, 0)))
}
