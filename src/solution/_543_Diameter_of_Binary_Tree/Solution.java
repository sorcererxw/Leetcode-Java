package solution._543_Diameter_of_Binary_Tree;

import models.TreeNode;

class Solution {
    private int result = 0;

    private int deepest(TreeNode root) {
        if (root == null) return 0;
        int left = deepest(root.left);
        int right = deepest(root.right);
        if (result < left + right) {
            result = left + right;
        }
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        deepest(root);
        return result;
    }
}