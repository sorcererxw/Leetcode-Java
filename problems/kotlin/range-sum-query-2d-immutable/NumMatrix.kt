package solution._304_Range_Sum_Query_2D_Immutable

/**
 * @author: sorcererxw
 * @date: 2019/4/2
 * @description:
 */
class NumMatrix(matrix: Array<IntArray>) {

    private val h: Int = matrix.size
    private val w: Int = if (matrix.isEmpty()) 0 else matrix[0].size
    private val records: Array<IntArray> = Array(h) { IntArray(w) }

    init {
        for (i in 0 until h) {
            var sum = 0
            for (j in 0 until w) {
                sum += matrix[i][j]
                if (i == 0) {
                    records[i][j] = sum
                } else {
                    records[i][j] = sum + records[i - 1][j]
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = records[row2][col2]
        if (row1 > 0 && col1 > 0) sum += records[row1 - 1][col1 - 1]
        if (row1 > 0) sum -= records[row1 - 1][col2]
        if (col1 > 0) sum -= records[row2][col1 - 1]
        return sum
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */