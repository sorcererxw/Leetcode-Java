/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class _21_Merge_Two_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode head;
        ListNode current;
        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
                current = current.next;
            }
        }else{
            while (l1!=null){
                current.next = new ListNode(l1.val);
                l1 = l1.next;
                current = current.next;
            }
        }
        return head;
    }
}
