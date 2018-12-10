package solution._492_Construct_the_Rectangle

/**
 * @author: SorcererXW
 * @date: 2018/5/17
 * @description:
 */

class Solution {
    fun constructRectangle(area: Int): IntArray {
        val minLen = Math.ceil(Math.sqrt(area * 1.0)).toInt()
        for (l in minLen..area) {
            if (area % l == 0) {
                return intArrayOf(l, area / l)
            }
        }
        return intArrayOf(area, 1)
    }
}

fun main(args: Array<String>) {
    println(Solution().constructRectangle(6).toList().toString())
}
