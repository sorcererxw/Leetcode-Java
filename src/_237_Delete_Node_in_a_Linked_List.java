/**
 * Created by Sorcerer on 2016/1/3 0003.
 * <p>
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class _237_Delete_Node_in_a_Linked_List {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    输入的node不是链表结尾
    只要用next覆盖当前node
    删除next即可
     */

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        System.gc();
    }
}
