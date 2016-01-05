/**
 * Created by Sorcerer on 2016/1/5 0005.
 * <p>
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class _110_Balanced_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depthLeft = getDepth(root.left);
        int depthRight = getDepth(root.right);
        return depthLeft - depthRight <= 1 && depthLeft - depthRight >= -1 && isBalanced(root.right) && isBalanced(root.left);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
