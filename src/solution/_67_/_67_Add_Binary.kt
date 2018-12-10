package solution.__67_Add_Binary

/**
 * @author: SorcererXW
 * @date: 2018/5/17
 * @description:
 */

class Solution {
    fun addBinary(a: String, b: String): String {
        val aLen = a.length
        val bLen = b.length
        val aArr = IntArray(aLen, {
            a[aLen - 1 - it] - '0'
        })
        val bArr = IntArray(bLen, {
            b[bLen - 1 - it] - '0'
        })
        val res = IntArray(aLen + bLen + 2, { 0 })
        var over = 0
        var idx = 0
        while (true) {
            if (idx >= aLen && idx >= bLen && over == 0) break
            var av = 0
            var bv = 0
            if (idx < aLen) av = aArr[idx]
            if (idx < bLen) bv = bArr[idx]
            res[idx] = av + bv + over
            over = res[idx] / 2
            res[idx] %= 2
            idx++
        }
        var s = ""
        for (i in res.size - 1 downTo 0) {
            if (res[i] == 0 && s.isEmpty()) {
                continue
            }
            s += res[i]
        }
        if (s.isEmpty()) return "0"
        return s
    }
}

fun main(args: Array<String>) {
    print(Solution().addBinary("0", "0"))
}
