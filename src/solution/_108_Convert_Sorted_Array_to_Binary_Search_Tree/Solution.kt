package solution._108_Convert_Sorted_Array_to_Binary_Search_Tree

import models.TreeNode

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return build(nums, 0, nums.size - 1)
    }

    private fun build(nums: IntArray, st: Int, ed: Int): TreeNode? {
        if (st > ed || st < 0 || ed < 0 || st >= nums.size || ed >= nums.size) return null
        val mid = st + (ed - st) / 2
        val root = TreeNode(nums[mid])
        root.left = build(nums, st, mid - 1)
        root.right = build(nums, mid + 1, ed)
        return root
    }
}