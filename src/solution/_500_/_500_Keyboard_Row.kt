package solution._500_Keyboard_Row

/**
 * @author: SorcererXW
 * @date: 2018/5/21
 * @description:
 */

class Solution {
    companion object {
        val KEYBOARD: IntArray = intArrayOf(1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2)
    }

    private fun check(it: String): Boolean {
        if (it.isEmpty()) return true
        val type: Int = KEYBOARD[it[0].toLowerCase() - 'a']
        for (i in 0 until it.length) {
            val idx = it[i].toLowerCase() - 'a'
            if (type != KEYBOARD[idx]) {
                return false
            }
        }
        return true
    }

    fun findWords(words: Array<String>): Array<String> {
        return words.filter {
            check(it)
        }.toTypedArray()
    }
}

fun main(args: Array<String>) {
    Solution().findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")).forEach { println(it) }
//    val row: Array<String> = Array(3, {
//        when (it) {
//            0 -> "qwertyuiop"
//            1 -> "asdfghjkl"
//            2 -> "zxcvbnm"
//            else -> ""
//        }
//    })
//    for (i in 'a' - 'a'..'z' - 'a') {
//        val c = 'a' + i
//        for (j in 0 until row.size) {
//            if (row[j].contains(c)) {
//                print("$j,")
//                break
//            }
//        }
//    }
}
