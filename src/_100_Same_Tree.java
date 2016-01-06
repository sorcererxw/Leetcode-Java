import models.TreeNode;

/**
 * Created by Sorcerer on 2016/1/3 0003.
 *
 * https://leetcode.com/problems/same-tree/
 */
public class _100_Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            } else {
                return false;
            }
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
