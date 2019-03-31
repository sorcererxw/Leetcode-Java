package solution._205_Isomorphic_Strings

import util.println

/**
 * @author: sorcererxw
 * @date: 2019/3/31
 * @description:
 */
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val len = s.length
        val smap: MutableMap<Char, Char> = HashMap(30)
        val tmap: MutableMap<Char, Char> = HashMap(30)
        for (i in 0 until len) {
            if (smap[s[i]] != null || tmap[t[i]] != null) {
                if (smap[s[i]] != t[i] || tmap[t[i]] != s[i]) return false
            } else {
                smap[s[i]] = t[i]
                tmap[t[i]] = s[i]
            }
        }
        return true
    }
}

fun main() {
    Solution().isIsomorphic("egg", "add").println()
    Solution().isIsomorphic("foo", "bar").println()
    Solution().isIsomorphic("paper", "title").println()
    Solution().isIsomorphic("ab", "aa").println()

}