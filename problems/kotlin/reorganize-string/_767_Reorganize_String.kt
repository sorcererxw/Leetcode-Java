package _767_Reorganize_String

/**
 * @author: SorcererXW
 * @date: 2018/5/16
 * @description:
 */

class Solution {
    private lateinit var map: IntArray

    private fun int2char(i: Int): Char {
        return 'a' + i
    }

    private fun char2int(c: Char): Int {
        return c - 'a'
    }

    private fun biggest(except: Int): Int {
        var max = 0
        var maxIdx = -1
        for (i in 0 until map.size) {
            if (i == except) {
                continue
            }
            if (maxIdx == -1) {
                max = map[i]
                maxIdx = i
                continue
            }
            if (map[i] > max) {
                maxIdx = i
                max = map[i]
            }
        }
        map[maxIdx]--
        return maxIdx
    }

    fun reorganizeString(S: String): String {
        map = IntArray(30, { 0 })
        var max = 0
        for (i in 0 until S.length) {
            val c = S[i]
            val idx = char2int(c)
            map[idx]++
            if (map[idx] > max) {
                max = map[idx]
            }
        }
        if (S.length % 2 == 0 && max > S.length / 2) return ""
        else if (S.length % 2 != 0 && max > (S.length / 2 + 1)) return ""
        var result = ""
        for (i in 0 until S.length) {
            if (i == 0) {
                result += int2char(biggest(-1))
                continue
            }
            result += int2char(biggest(char2int(result[i - 1])))
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution().reorganizeString("aaab"))
}
