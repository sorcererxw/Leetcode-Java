/**
 * Created by Sorcerer on 2016/1/3 0003.
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
