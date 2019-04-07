package solution._687_Longest_Univalue_Path

import models.TreeNode
import util.println

/**
 * @author: sorcererxw
 * @date: 2019/4/7
 * @description:
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private var max = 0

    private fun travel(root: TreeNode?, parent: Int): Int {
        if (root == null) return 0
        if (root.`val` != parent) {
            var left = travel(root.left, root.`val`)
            var right = travel(root.right, root.`val`)
            if (left + right + 1 > max) {
                max = left + right + 1
            }
            return 0
        } else {
            var left = travel(root.left, parent)
            var right = travel(root.right, parent)

            return Math.max(left, right) + 1
        }
    }

    fun longestUnivaluePath(root: TreeNode?): Int {
        if (root == null) return 0
        max = 0
        travel(root, Int.MAX_VALUE)
        return if (max > 0) max - 1
        else 0
    }
}

fun main() {
    var node = TreeNode.build(intArrayOf(5, 4, 5, 1, 1, -1, 5).toTypedArray())
    Solution().longestUnivaluePath(node).println()
}