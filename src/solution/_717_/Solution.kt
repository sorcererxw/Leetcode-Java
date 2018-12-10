package solution._717_

/**
 * @author: Sorcerer
 * @date: 12/4/2018
 * @description:
 */
class Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var last = 0
        for (i in 0 until bits.size - 1) {
            if (last == 1) last = 0
            else if (bits[i] == 1) last = 1
        }
        if (last == 1 || bits[bits.size - 1] != 0) {
            return false
        }
        return true
    }
}