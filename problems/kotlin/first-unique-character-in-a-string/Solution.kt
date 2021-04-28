package solution._387_First_Unique_Character_in_a_String

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/first-unique-character-in-a-string/
 */
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = IntArray(26) { 0 }
        for (c in s) {
            map[c - 'a'] += 1
        }
        for (i in 0 until s.length) {
            if(map[s[i]-'a']==1)return i
        }
        return -1
    }
}