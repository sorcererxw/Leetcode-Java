import models.TreeNode;

/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        if (root.val <= p.val && root.val >= q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
