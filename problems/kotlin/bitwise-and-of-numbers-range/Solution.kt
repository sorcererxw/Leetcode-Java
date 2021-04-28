package solution._201_Bitwise_AND_of_Numbers_Range

/**
 * 可以理解为如果高位有不同，那么这个高位以下的低位必然要经历 0，1来成全高位
 */
class Solution {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        if (m == n) return m
        return rangeBitwiseAnd(m shr 1, n shr 1) shl 1
    }
}
