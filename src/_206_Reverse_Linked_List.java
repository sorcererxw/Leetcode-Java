/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class _206_Reverse_Linked_List {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = last;
            last = head;
            head = tmp;
        }
        return last;
    }
}
