package solution._24_Swap_Nodes_in_Pairs

import models.ListNode

/**
 * @author: Sorcerer
 * @date: 2/19/2019
 * @description: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val first = head
        val second = head?.next
        return when {
            first == null || second == null -> first
            else -> {
                first.next = swapPairs(second.next)
                second.next = first
                second
            }
        }
    }
}

fun main(args: Array<String>) {
    val testCase = ListNode.build(intArrayOf(1, 2, 3, 4, 5))
    var head = Solution().swapPairs(testCase)
    while (head != null) {
        println(head.`val`)
        head = head.next
    }
}