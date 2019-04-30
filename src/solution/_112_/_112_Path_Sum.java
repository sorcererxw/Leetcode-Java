package solution._112_;

import models.TreeNode;

/**
 * Created by Sorcerer on 2016/1/7 0007.
 * <p>
 * https://leetcode.com/problems/path-sum/
 */
public class _112_Path_Sum {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-2);
        treeNode.right = new TreeNode(-3);
        System.out.println(hasPathSum(treeNode, -2));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return calculate(root, sum);
    }

    public static boolean calculate(TreeNode root, int sum) {
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean flag = false;
        if (root.left != null) {
            flag = flag || calculate(root.left, sum - root.val);
        }

        if (root.right != null && flag == false) {
            flag = flag || calculate(root.right, sum - root.val);
        }
        return flag;
    }
}
