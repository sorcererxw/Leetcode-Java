package solution._138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sorcerer
 * @date: 2/25/2019
 * @description: https://leetcode.com/problems/copy-list-with-random-pointer/
 * 通过一个 map，把新旧node一一对应起来，只需要遍历旧链表，就能同时修改新链表
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>(16);
        Node node = head;
        while (node != null) {
            Node newNode = new Node();
            newNode.val = node.val;
            map.put(node, newNode);
            node = node.next;
        }
        node = head;
        while (node != null) {
            Node newNode = map.get(node);
            newNode.next = map.get(node.next);
            newNode.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};