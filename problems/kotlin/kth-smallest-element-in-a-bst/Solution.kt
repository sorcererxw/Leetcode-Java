package solution._230_Kth_Smallest_Element_in_a_BST

import models.TreeNode

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
class Solution {
    private var count = 0
    private var result: TreeNode? = null

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        count = k
        result = null
        query(root)
        return result!!.`val`
    }

    private fun query(root: TreeNode?) {
        if (root == null) return
        if (result != null) return
        query(root.left)
        count--
        if (count == 0) {
            result = root
        }
        query(root.right)
    }
}
