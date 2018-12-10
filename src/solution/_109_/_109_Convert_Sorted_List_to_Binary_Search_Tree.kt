package solution.__109_Convert_Sorted_List_to_Binary_Search_Tree

import models.ListNode
import models.TreeNode
import util.Utility

/**
 * @author: SorcererXW
 * @date: 2018/5/15
 * @description:
 */

class Solution {
    private fun build(list: List<Int>, st: Int, ed: Int): TreeNode? {
        if (st < 0 || ed < 0 || st >= list.size || ed >= list.size || st > ed) {
            return null
        }
        var mid = (st + ed)
        if (mid % 2 == 0) mid /= 2
        else mid = mid / 2 + 1
        val root = TreeNode(list[mid])
        root.left = build(list, st, mid - 1)
        root.right = build(list, mid + 1, ed)
        return root
    }

    fun sortedListToBST(head: ListNode?): TreeNode? {
        val list = ArrayList<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        return build(list, 0, list.size - 1)
    }
}

fun main(args: Array<String>) {

    val tree = Solution().sortedListToBST(
            ListNode.build(intArrayOf(-10, -3, 0, 5, 9))
    )

    Utility.printTreeNode(tree)
}
