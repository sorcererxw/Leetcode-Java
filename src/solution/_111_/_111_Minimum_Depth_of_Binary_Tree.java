import models.TreeNode;

/**
 * Created by Sorcerer on 2016/1/8 0008.
 * <p>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode root, int step) {
        if (root == null) {
            return step;
        }
        if(root.right!=null && root.left!=null) {
            return 1 + Math.min(getDepth(root.left, step), getDepth(root.right, step));
        }else if(root.left==null){
            return 1 + getDepth(root.right, step);
        }else{
            return 1 + getDepth(root.left, step);
        }
    }
}
