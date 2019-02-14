package solution._141_Linked_List_Cycle;

import models.ListNode;

import static models.ListNode.buildCycleNodeList;

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description: https://leetcode.com/problems/linked-list-cycle/
 * 定义两个指针，一个走快点，一个走慢点，如果有环，快的那个迟早嘴上慢的那个
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && slow.next != null) {
            slow = slow.next;
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert (solution.hasCycle(buildCycleNodeList(new int[0], -1)));
        assert (solution.hasCycle(buildCycleNodeList(new int[]{3, 2, 0, -4}, 1)));
        assert (solution.hasCycle(buildCycleNodeList(new int[]{1, 2}, 0)));
        assert (!solution.hasCycle(buildCycleNodeList(new int[]{1}, -1)));
    }
}