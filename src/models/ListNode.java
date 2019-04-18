package models;

import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;

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

    public static ListNode buildCycleNodeList(int[] value, int cycleEntry) {
        if(value.length==0) {
            return null;
        }
        ListNode[] nodes = new ListNode[value.length];
        for (int i = 0; i < value.length; i++) {
            nodes[i] = new ListNode(value[i]);
            if (i != 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        if (cycleEntry >= 0 && cycleEntry < nodes.length) {
            nodes[nodes.length - 1].next = nodes[cycleEntry];
        }

        return nodes[0];
    }

    @SuppressWarnings("Duplicates")
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
