package solution._985_Sum_of_Even_Numbers_After_Queries

/**
 * @author: sorcererxw
 * @date: 2019/4/2
 * @description:
 */
class Solution {
    fun sumEvenAfterQueries(A: IntArray, queries: Array<IntArray>): IntArray {
        var sum = A.filter { it % 2 == 0 }.sum()
        var result = IntArray(queries.size)
        for (i in 0 until queries.size) {
            val index = queries[i][1]
            val num = queries[i][0]
            if (index in 0 until A.size) {
                if (A[index] % 2 == 0) {
                    sum -= A[index]
                }
                A[index] += num
                if (A[index] % 2 == 0) {
                    sum += A[index]
                }
            }
            result[i] = sum
        }
        return result
    }
}