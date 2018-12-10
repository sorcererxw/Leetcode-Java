package _40_Combination_Sum_II

/**
 * @author: SorcererXW
 * @date: 2018/5/18
 * @description:
 */

class Solution {
    private lateinit var list: MutableSet<List<Int>>

    private fun cal(candidates: IntArray, target: Int, now: Int, result: MutableList<Int>) {
        if (target == 0) {
            list.add(result)
            return
        }
        if (now >= candidates.size) return
        if (candidates[now] > target) return
        cal(candidates, target, now + 1, result.toMutableList())
        result.add(candidates[now])
        cal(candidates, target - candidates[now], now + 1, result.toMutableList())
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        list = HashSet()
        cal(candidates, target, 0, ArrayList())
        return list.toList()
    }
}

fun main(args: Array<String>) {
    println(Solution().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(Solution().combinationSum2(intArrayOf(2,5,2,1,2), 5))
}
