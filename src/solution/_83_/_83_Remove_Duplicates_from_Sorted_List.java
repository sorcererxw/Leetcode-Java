import models.ListNode;

/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp;
    }
}
