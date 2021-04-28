package solution._845_

/**
 * @author: Sorcerer
 * @date: 12/5/2018
 * @description:
 */
class Solution {
    fun longestMountain(A: IntArray): Int {
        var max = 0
        var now = 1
        var isAsc = true
        var foundMountain = false
        for (i in 1 until A.size) {
            if (isAsc && A[i] > A[i - 1]) {
                now++
                foundMountain = true
            } else if (!isAsc && A[i] < A[i - 1]) {
                now++
            } else if (isAsc && A[i] < A[i - 1]) {
                now++
                isAsc = false
            } else {
                now = 1
                isAsc = true
            }
            if (now > max) max = now
        }
        return if (foundMountain) max else 0
    }
}

fun main(args: Array<String>) {
    println(Solution().longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
}