import models.TreeNode;

/**
 * Author: Sorcerer
 * Date: 2018/4/29
 * Description:
 */
public class _129_Sum_Root_to_Leaf_Numbers {
    private int cal(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int res = sum*10+root.val;
        if (root.left == null && root.right == null) {
            return res;
        }
        if (root.left == null && root.right != null) {
            return cal(root.right, res);
        }
        if (root.left != null && root.right == null) {
            return cal(root.left, res);
        }
        return cal(root.left, res) + cal(root.right, res);
    }

    public int sumNumbers(TreeNode root) {
        return cal(root, 0);
    }

    public static void main(String[] args) {
        _129_Sum_Root_to_Leaf_Numbers solution = new _129_Sum_Root_to_Leaf_Numbers();
        System.out.println(
                solution.sumNumbers(
                        TreeNode.build(new int[]{1, 2, 3})
                )
        );
    }
}
