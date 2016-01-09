import models.ListNode;
import util.Utility;

/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_Remove_Nth_Node_From_End_of_List {

    public static void main(String[] args) {
        ListNode head = Utility.generateListNodeList(new int[]{1, 2, 3, 4, 5});
        Utility.printListNodeList(removeNthFromEnd(head,5));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int len = getListLength(head);
        if (len <= 1) {
            return null;
        }
        if (len == n) {
            return head.next;
        }
        for (int i = 1; i <= len; i++) {
            if (i + n == len) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    private static int getListLength(ListNode head) {
        int cnt = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }
}
