package util;

import models.ListNode;

/**
 * Created by Sorcerer on 2016/1/3 0003.
 */
public class Utility {
    public static void printIntArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }

    public static void printCharArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("");
    }

    public static void printListNodeList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public static ListNode initListNodeList(int[] nums) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < nums.length; i++) {
            if (current == null) {
                current = new ListNode(nums[i]);
                head = current;
            } else {
                current.next = new ListNode(nums[i]);
                current = current.next;
            }
        }
        return head;
    }
}
