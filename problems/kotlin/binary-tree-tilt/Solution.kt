package solution._563_

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
    private var sum = 0

    fun sum(root: TreeNode?): Int {
        if (root == null) return 0
        val left = sum(root.left)
        val right = sum(root.right)
        sum += Math.abs(left - right)
        return left + right + root.`val`
    }

    fun findTilt(root: TreeNode?): Int {
        sum = 0
        sum(root)
        return sum
    }
}