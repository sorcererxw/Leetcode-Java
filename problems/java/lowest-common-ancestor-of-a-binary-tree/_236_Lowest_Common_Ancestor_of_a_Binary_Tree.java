import models.TreeNode;

/**
 * Author: Sorcerer
 * Date: 2018/4/28
 * Description:
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        TreeNode result = lowestCommonAncestor(root.left, p, q);
        return null;
    }
}
