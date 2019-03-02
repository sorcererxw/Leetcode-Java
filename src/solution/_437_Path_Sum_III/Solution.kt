package solution._437_Path_Sum_III

import models.TreeNode

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/path-sum-iii/
 */
class Solution {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        return dfs(root, 0, sum)
    }

    private fun dfs(root: TreeNode?, pre: Int, sum: Int): Int {
        if (root == null) return 0
        val now = pre + root.`val`
        return ((if (now == sum) 1 else 0)
                + dfs(root.left, 0, sum) + dfs(root.right, 0, sum)
                + dfs(root.left, now, sum) + dfs(root.right, now, sum)
                )
    }
}

fun main(args: Array<String>) {
    val tree = TreeNode.build(arrayOf(1,null,2,null,3,null,4,null,5))
    val result = Solution().pathSum(tree, 3)
    println(result)
}