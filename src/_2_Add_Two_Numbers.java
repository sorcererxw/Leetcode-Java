import models.ListNode;

/**
 * Author: Sorcerer
 * Date: 2018/4/19
 * Description:
 */
public class _2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null, cur = null;
        int over = 0;
        while (l1 != null || l2 != null || over != 0) {
            int k = over;
            if (l1 != null) {
                k += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                k += l2.val;
                l2 = l2.next;
            }
            over = k / 10;
            if (node == null) {
                node = new ListNode(k % 10);
                cur = node;
            } else {
                cur.next = new ListNode(k % 10);
                cur = cur.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        _2_Add_Two_Numbers solution = new _2_Add_Two_Numbers();
        solution.addTwoNumbers(
                ListNode.build(new int[]{2, 4, 3}),
                ListNode.build(new int[]{5, 6, 4})
        ).print();
    }
}
