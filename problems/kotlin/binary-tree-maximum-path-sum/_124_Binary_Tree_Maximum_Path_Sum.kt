package _124_Binary_Tree_Maximum_Path_Sum

import models.TreeNode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private var max = 0
    private var flag = false

    private fun setMax(max: Int) {
        if (!flag) {
            this.max = max
            flag = true
        } else {
            if (max > this.max) {
                this.max = max
            }
        }
    }

    private fun cal(root: TreeNode?): Int {
        if (root == null) return 0
        val left = maxPathSum(root.left)
        val right = maxPathSum(root.right)
        var sum = root.`val`
        if (left >= 0 && right >= 0) {
            sum += left + right
        } else if (left < 0 && right < 0) {
            val lsum = sum + left
            val rsum = sum + right
            sum = if (lsum < 0 && rsum < 0) {
                0
            } else {
                Math.max(lsum, rsum)
            }
        } else if (left >= 0 && right < 0) {
            sum += left
        } else if (left < 0 && right >= 0) {
            sum += right
        }
        setMax(sum)
        return sum
    }

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) return 0
        flag = false
        max = root.`val`
        cal(root)
        return max
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.maxPathSum(
            TreeNode.build(arrayOf(-10, 9, 20, null, null, 15, 7))
    ))
}
