package solution._297_Serialize_and_Deserialize_Binary_Tree;

import models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Sorcerer
 * @date: 2/26/2019
 * @description: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();
        int end = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node);
            if (node == null) continue;
            end = list.size();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < end; i++) {
            if (i > 0) result.append(",");
            if (list.get(i) == null) result.append("null");
            else result.append(list.get(i).val);
        }
        return "[" + result + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String trimData = data.substring(1, data.length() - 1);
        if (trimData.isEmpty()) return null;
        String[] items = trimData.split(",");
        if (items.length == 0) return null;

        int n = items.length;

        List<TreeNode> list = new ArrayList<>();
        for (String item : items) {
            if (item.equals("null")) list.add(null);
            else list.add(new TreeNode(Integer.parseInt(item)));
        }
        int now = 1;
        for (int i = 0; i < n; i++) {
            if (list.get(i) == null) continue;
            list.get(i).left = now < n ? list.get(now++) : null;
            list.get(i).right = now < n ? list.get(now++) : null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[5,2,3,null,null,2,4,3,1]");
        System.out.println(codec.serialize(root));
    }
}