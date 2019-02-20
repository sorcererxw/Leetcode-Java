package solution._79_Word_Search

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/word-search/
 */
class Solution {
    private lateinit var vst: Array<BooleanArray>
    private lateinit var board: Array<CharArray>
    private lateinit var word: String

    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty()) return false
        this.board = board
        this.word = word
        this.vst = Array(board.size) { BooleanArray(board[0].size) { false } }

        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (board[i][j] == word[0]) {
                    val result = dfs(0, i, j)
                    if (result) return true
                }
            }
        }
        return false
    }

    private fun dfs(idx: Int, x: Int, y: Int): Boolean {
        if (idx >= word.length) return true
        if (x >= board.size || x < 0 || y < 0 || y >= board[0].size) return false

//        println("x: $x y: $y ${board[x][y]}")

        if (word[idx] == board[x][y] && !vst[x][y]) {
            vst[x][y] = true
            val result = dfs(idx + 1, x + 1, y)
                    || dfs(idx + 1, x, y + 1)
                    || dfs(idx + 1, x - 1, y)
                    || dfs(idx + 1, x, y - 1)
            vst[x][y] = false
            return result
        }
        return false
    }
}

fun main(args: Array<String>) {
    val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
    )
    println( Solution().exist(emptyArray(),"ABCB"))

    println( Solution().exist(board,"ABCCED"))
    println( Solution().exist(board,"SEE"))
    println( Solution().exist(board,"ABCB"))

}