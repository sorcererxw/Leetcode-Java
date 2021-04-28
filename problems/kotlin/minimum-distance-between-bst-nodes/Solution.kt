package solution._783_Minimum_Distance_Between_BST_Nodes

import models.TreeNode

class Solution {
    private var min = Int.MAX_VALUE
    private var lastNode: TreeNode? = null

    private fun inOrderQuery(root: TreeNode?) {
        if (root == null) return
        inOrderQuery(root.left)
        if (lastNode != null) {
            min = Math.min(min, Math.abs(root.`val` - lastNode!!.`val`))
        }
        lastNode = root
        inOrderQuery(root.right)
    }

    fun minDiffInBST(root: TreeNode?): Int {
        lastNode=null
        min = Int.MAX_VALUE
        inOrderQuery(root)
        return min
    }
}