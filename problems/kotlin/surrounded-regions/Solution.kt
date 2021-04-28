package solution._130_Surrounded_Regions

/**
 * @author: Sorcerer
 * @date: 2/26/2019
 * @description: https://leetcode.com/problems/surrounded-regions/
 * 先从四周找到 O, BFS全部反过来标记成 -
 * 然后图中剩下都 O 都是要翻成 x 的
 * O->X
 * 最后 - -> O
 */
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        if(board.isEmpty())return
        for (i in 0 until board.size) {
            if (board[i][0] == 'O') {
                flip(board, i, 0, 'O', '-')
            }
            if (board[i][board[i].size - 1] == 'O') {
                flip(board, i, board[i].size - 1, 'O', '-')
            }
        }
        for (i in 0 until board[0].size) {
            if (board[0][i] == 'O') {
                flip(board, 0, i, 'O', '-')
            }
            if (board[board.size - 1][i] == 'O') {
                flip(board, board.size - 1, i, 'O', '-')
            }
        }

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j] == 'O') board[i][j] = 'X'
            }
        }
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j] == '-') board[i][j] = 'O'
            }
        }


    }

    private fun flip(board: Array<CharArray>, x: Int, y: Int, from: Char, to: Char) {
        if (x >= board.size || x < 0 || y < 0 || y >= board[x].size) return
        if (board[x][y] != from) return
        board[x][y] = to
        flip(board, x - 1, y, from, to)
        flip(board, x + 1, y, from, to)
        flip(board, x, y + 1, from, to)
        flip(board, x, y - 1, from, to)
    }
}

fun main(args: Array<String>) {
    Solution().solve(arrayOf(
    ))
    Solution().solve(arrayOf(
            "XXXX".toCharArray(),
            "XOOX".toCharArray(),
            "XXOX".toCharArray(),
            "XOXX".toCharArray()
    ))
}