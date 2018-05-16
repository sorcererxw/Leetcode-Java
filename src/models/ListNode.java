package models;

/**
 * Created by Sorcerer on 2016/1/6 0006.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int[] val) {
        ListNode root = null, cur = null;
        for (int i = 0; i < val.length; i++) {
            if (root == null) {
                root = new ListNode(val[i]);
                cur = root;
            } else {
                cur.next = new ListNode(val[i]);
                cur = cur.next;
            }
        }
        return root;
    }

    public void print() {
        System.out.print(this.val);
        ListNode node = this.next;
        while (node != null) {
            System.out.print(" -> " + node.val);
            node = node.next;
        }
        System.out.println();
    }
}
