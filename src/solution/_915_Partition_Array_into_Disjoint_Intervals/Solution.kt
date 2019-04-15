package solution._915_Partition_Array_into_Disjoint_Intervals


/**
 * @author: sorcererxw
 * @date: 2019/4/15
 * @description:
 */
class Solution {
    fun partitionDisjoint(A: IntArray): Int {
        val n = A.size
        val maxLeft = IntArray(n)
        val minRight = IntArray(n)

        var m = A[0]
        for (i in 0 until n) {
            m = Math.max(m, A[i])
            maxLeft[i] = m
        }
        m = A[n - 1]
        for (i in n - 1 downTo 0) {
            m = Math.min(m, A[i])
            minRight[i] = m
        }

        for (i in 1 until n)
            if (minRight[i] >= maxLeft[i - 1]) return i

        throw Exception()
    }
}