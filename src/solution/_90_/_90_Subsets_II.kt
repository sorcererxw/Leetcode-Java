package solution.__90_Subsets_II

/**
 * @author: SorcererXW
 * @date: 2018/5/15
 * @description:
 */

class Solution {
    private lateinit var set: MutableSet<List<Int>>
    private lateinit var current: MutableList<Int>

    private fun process(nums: IntArray, idx: Int) {
        if (idx >= nums.size) return
        current.add(nums[idx])
        set.add(current.toList())
        process(nums, idx + 1)
        current.removeAt(current.size - 1)
        set.add(current.toList())
        process(nums, idx + 1)
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        set = HashSet()
        current = ArrayList()
        process(nums.sortedArray(), 0)

        val list = ArrayList<List<Int>>()
        set.forEach({
            list.add(it)
        })
        return list
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)))
}
