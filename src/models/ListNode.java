package models;

/**
 * @author Sorcerer
 * @date 2016/1/6 0006
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int[] value) {

        ListNode root = null, cur = null;
        for (int val : value) {
            if (root == null) {
                root = new ListNode(val);
                cur = root;
            } else {
                cur.next = new ListNode(val);
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
