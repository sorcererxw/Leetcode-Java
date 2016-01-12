import models.ListNode;
import util.Utility;

/**
 * Created by Sorcerer on 2016/1/12 0012.
 * <p>
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class _203_Remove_Linked_List_Elements {

    public static void main(String[] args) {
        Utility.printListNodeList(removeElements(Utility.generateListNodeList(new int[]{1, 1, 1, 1, 1, 1}), 1));
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next != null && tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
