package solution._142_Linked_List_Cycle_II;

import models.ListNode;

import static models.ListNode.buildCycleNodeList;

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description: https://leetcode.com/problems/linked-list-cycle-ii/
 * 其实可以将找环和计算长度合并为一步
 * 因为快指针每次2步，慢指针每次1步，等到相遇，他们距离head的距离刚好就是环的长度
 * 这个时候，只需要直接从起点出发一个慢指针，与原来的慢指针同步前进，就会在环入口相遇
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode node = hasCycle(head);
        if (node == null) {
            return null;
        }
        int length = calculateCycleLength(node);
        return findCycleEntry(head, length);
    }

    /**
     * check is node list has cycle, is has cycle then return any node in cycle
     *
     * @param head first item of node list
     * @return any node in cycle
     */
    private ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && slow.next != null) {
            slow = slow.next;
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                if (slow == fast) {
                    return slow;
                }
            }
        }
        return null;
    }

    /**
     * @param head any node of cycle
     * @return cycle length
     */
    private int calculateCycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 1;
        ListNode node = head.next;
        while (node != head) {
            node = node.next;
            len++;
        }
        return len;
    }

    private ListNode findCycleEntry(ListNode head, int cycleLength) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCycle(buildCycleNodeList(new int[0], -1)));
        System.out.println(solution.detectCycle(buildCycleNodeList(new int[]{3, 2, 0, -4}, 1)));
        System.out.println(solution.detectCycle(buildCycleNodeList(new int[]{1, 2}, 0)));
        System.out.println(solution.detectCycle(buildCycleNodeList(new int[]{1}, -1)));
    }
}