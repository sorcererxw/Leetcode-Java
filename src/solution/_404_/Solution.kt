package solution._404_

import models.TreeNode

/**
 * @author: Sorcerer
 * @date: 12/10/2018
 * @description:
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private fun cal(root: TreeNode?, isLeft: Boolean): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) {
            return if (isLeft) root.`val` else 0
        }
        return cal(root.left, true) + cal(root.right, false)
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return cal(root, false)
    }
}