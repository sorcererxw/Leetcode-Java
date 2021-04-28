package algorithm.string

/**
 * @author: sorcererxw
 * @date: 2019/3/28
 * @description:
 */
class KMP {

    // 生成部匹配表
    private fun kmpHelper(pat: String, m: Int): IntArray {
        val arr = IntArray(m)
        var i = 1
        var len = 0
        while (i < m) {
            if (pat[i] == pat[len]) {
                arr[i++] = ++len
            } else {
                if (len > 0) len = arr[len - 1]
                else i++
            }
        }

        return arr
    }

    fun kmp(txt: String, pat: String): List<Int> {
        val matches: MutableList<Int> = ArrayList()

        val m = pat.length
        val n = txt.length

        if (m > n) return matches

        val arr = kmpHelper(pat, m)

        var i = 0
        var j = 0
        while (i < n) {
            if (pat[j] == txt[i]) {
                i++
                j++
            }
            if (j == m) { // 证明完整匹配
                matches.add(i - j) // 存入最初匹配点
                j = arr[j - 1] // 根据匹配表回滚匹配点
            } else if (i < n && pat[j] != txt[i]) {
                if (j != 0) j = arr[j - 1]
                else i += 1
            }
        }
        return matches
    }
}