import java.util.*

/**
 * @author: Sorcerer
 * @date: 11/2/2018
 * @description:
 */
class _18_4sSum {
    companion object {
        private const val LIMIT = 4
    }

    private var nowSum = 0
    private var nowArray = Stack<Int>()
    private var target = 0
    private var nums = intArrayOf()
    private var result = listOf<List<Int>>()
    private fun dfs(idx: Int) {
        if (idx >= nums.size) {
            if (nowArray.size > 0) nowArray.pop()
            return
        }

    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        this.target = target
        nowSum = 0
        this.nums = nums
        result = emptyList()
//        dfs()
        return result
    }
}

fun main(args: Array<String>) {

}