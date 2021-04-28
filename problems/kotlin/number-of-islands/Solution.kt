package solution._200_Number_of_Islands

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/number-of-islands/
 */
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == '1') {
                    count++
                    flap(grid, i, j)
                }
            }
        }
        return count
    }

    private fun flap(grid: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[x].size) return
        if (grid[x][y] == '0') return
        grid[x][y] = '0'
        flap(grid, x + 1, y)
        flap(grid, x, y + 1)
        flap(grid, x - 1, y)
        flap(grid, x, y - 1)
    }
}