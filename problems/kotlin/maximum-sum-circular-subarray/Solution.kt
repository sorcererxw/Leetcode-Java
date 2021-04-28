package solution._918_Maximum_Sum_Circular_Subarray

/**
 * @author: sorcererxw
 * @date: 2019/4/2
 * @description:
 */
class Solution {
    // cal the sum in the left to right of the index 0
    private fun calStartSum(A: IntArray): Int {
        for (i in A.size - 1 downTo 0) {

        }
        return 0
    }

    // cal the sum that ignore circular
    private fun calSimpleSum(A: IntArray): Int {
        var sum = 0
        var max = 0
        var maxItem = A[0]
        for (i in 0 until A.size) {
            maxItem = Math.max(maxItem, i)
            sum += A[i]
            if (sum > max) max = sum
            if (sum < 0) sum = 0
        }
        if (maxItem < 0) return maxItem
        return max
    }

    fun maxSubarraySumCircular(A: IntArray): Int {
        if (A.isEmpty()) return 0
        if (A.size == 1) return A[0]
        return Math.max(calSimpleSum(A), calStartSum(A))
    }
}