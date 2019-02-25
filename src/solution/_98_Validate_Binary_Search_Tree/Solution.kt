package solution._98_Validate_Binary_Search_Tree

import models.TreeNode
import util.println

/**
 * @author: Sorcerer
 * @date: 2/25/2019
 * @description: https://leetcode.com/problems/validate-binary-search-tree/
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return check(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun check(root: TreeNode?, lowerBound: Int, upperBound: Int): Boolean {
        if (root == null) return true
        if (root.`val` < lowerBound || root.`val` > upperBound) return false
        if (root.`val` == Int.MAX_VALUE && root.right != null) return false
        if (root.`val` == Int.MIN_VALUE && root.left != null) return false
        return check(root.left, lowerBound, root.`val` - 1)
                && check(root.right, root.`val` + 1, upperBound)
    }
}

fun main(args: Array<String>) {
    (Int.MIN_VALUE - 1).println()
    (Int.MAX_VALUE + 1).println()

}