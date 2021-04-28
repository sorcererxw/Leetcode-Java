package solution._234_Palindrome_Linked_List

import models.ListNode

/**
 * @author: Sorcerer
 * @date: 2/21/2019
 * @description: https://leetcode.com/problems/palindrome-linked-list/
 * 1. 快慢指针找中点
 * 2. 后半段原地逆转链表
 * 3. 比较前后两半段
 */
class Solution {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        val mid = findMid(head)
        val reverse = reverse(mid.next, null) ?: return true
        return compare(head, reverse)
    }

    private fun findMid(head: ListNode): ListNode {
        var slow: ListNode = head
        var fast: ListNode? = head
        while (fast != null) {
            fast = fast.next
            if (fast != null) {
                fast = fast.next
            }
            if (fast != null) slow = slow.next
        }
        return slow
    }

    private fun reverse(headNode: ListNode?, parentNode: ListNode?): ListNode? {
        if (headNode == null) return null
        var head: ListNode? = headNode
        var parent: ListNode? = parentNode
        while (head != null) {
            val next = head.next
            head.next = parent
            parent = head
            head = next
        }
        return parent!!
    }

    private fun compare(head1: ListNode, head2: ListNode): Boolean {
        var p1: ListNode? = head1
        var p2: ListNode? = head2
        while (p1 != null && p2 != null) {
            if (p1.`val` != p2.`val`) return false
            p1 = p1.next
            p2 = p2.next
        }
        return true
    }
}

fun main(args: Array<String>) {
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1))))
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1, 2))))
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1, 2, 2, 1))))
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1, 2, 3, 2, 1))))
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1, 2, 2, 3, 1))))
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1, 2, 2, 2, 2, 1))))
    println(Solution().isPalindrome(ListNode.build(intArrayOf(1, 2, 3, 1))))

}