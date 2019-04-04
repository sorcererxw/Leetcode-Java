package solution._429_N_ary_Tree_Level_Order_Traversal;


import javafx.util.Pair;

import java.util.*;

/**
 * @author: sorcererxw
 * @date: 2019/4/4
 * @description:
 */

// Definition for a Node.
class Node {
    int val;
    List<Node> children;

    Node() {
    }

    Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    private List<List<Integer>> result;

    private void addRecord(int num, int level) {
        while (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(num);
    }

    private Queue<Pair<Node, Integer>> queue;

    @SuppressWarnings("WeakerAccess")
    public List<List<Integer>> levelOrder(Node root) {
        result = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.poll();
            Node node = pair.getKey();
            Integer level = pair.getValue();
            if (node != null) {
                addRecord(node.val, level);
                node.children.forEach(it -> queue.add(new Pair<>(it, level + 1)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(1, Collections.emptyList());
        new Solution().levelOrder(node);
    }
}