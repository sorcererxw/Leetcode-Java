package solution._63_Unique_Paths_II

/**
 * @author: sorcererxw
 * @date: 2019/4/7
 * @description:
 */
class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid.isEmpty()) return 0
        val h = obstacleGrid.size
        val w = obstacleGrid[0].size
        val pathGrid: Array<IntArray> = Array(h) { IntArray(w) { 0 } }
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (obstacleGrid[i][j] == 1) {
                    pathGrid[i][j] = 0
                    continue
                }
                if (i == 0 && j == 0) {
                    pathGrid[i][j] = 1
                    continue
                }
                val top = if (i > 0 && obstacleGrid[i - 1][j] == 0) pathGrid[i - 1][j] else 0
                val left = if (j > 0 && obstacleGrid[i][j - 1] == 0) pathGrid[i][j - 1] else 0
                pathGrid[i][j] = top + left
            }
        }
        return pathGrid[h - 1][w - 1]
    }
}