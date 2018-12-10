package solution._623_

import models.TreeNode

/**
 * @author: Sorcerer
 * @date: 12/4/2018
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
    /**
     * d>=2
     */
    private fun query(root: TreeNode?, level: Int, v: Int, d: Int) {
        if (root == null || level >= d) return
        if (level == d - 1) {
            val left = TreeNode(v)
            val right = TreeNode(v)
            left.left = root.left
            right.right = root.right
            root.left = left
            root.right = right
            return
        }
        if (level < d - 1) {
            query(root.left, level + 1, v, d)
            query(root.right, level + 1, v, d)
        }
    }

    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            val node = TreeNode(v)
            node.left = root
            return node
        }
        query(root, 1, v, d)
        return root
    }
}