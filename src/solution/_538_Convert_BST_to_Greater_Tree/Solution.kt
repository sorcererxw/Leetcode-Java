package solution._538_Convert_BST_to_Greater_Tree

import models.TreeNode

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description:
 */
class Solution {
    fun convertBST(root: TreeNode?): TreeNode? {
        query(root)
        return root
    }

    private var sum = 0

    private fun query(root: TreeNode?) {
        if (root == null) return
        query(root.right)
        sum += root.`val`
        root.`val` =sum
        query(root.left)
    }
}