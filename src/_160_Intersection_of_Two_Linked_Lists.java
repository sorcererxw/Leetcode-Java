import models.ListNode;
import util.Utility;

/**
 * Created by Sorcerer on 2016/1/8 0008.
 * <p>
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class _160_Intersection_of_Two_Linked_Lists {
    public static void main(String[] args) {
        ListNode a = Utility.initListNodeList(new int[]{1, 2, 3, 4, 5});
        ListNode b = Utility.initListNodeList(new int[]{3, 4, 5});
        Utility.printListNodeList(getIntersectionNode(a,b));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode i = headA;
        ListNode j = headB;
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        if (lenA > lenB) {
            while (lenA != lenB) {
                i = i.next;
                lenA--;
            }
        } else {
            while (lenB != lenA) {
                j = j.next;
                lenB--;
            }
        }
        while (i != null && i.val != j.val) {
            i = i.next;
            j = j.next;
        }
        return i;
    }

    public static int getListLength(ListNode head) {
        ListNode tmp = head;
        int sum = 0;
        while (tmp != null) {
            sum++;
            tmp = tmp.next;
        }
        return sum;
    }
}
