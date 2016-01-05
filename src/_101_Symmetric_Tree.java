/**
 * Created by Sorcerer on 2016/1/5 0005.
 * <p>
 * https://leetcode.com/problems/symmetric-tree/
 */
public class _101_Symmetric_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isReverse(root.left, root.right);
    }

    public boolean isReverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val == right.val) {
                return isReverse(left.left, right.right) && isReverse(right.left, left.right);
            }
        }
        return false;
    }
}
