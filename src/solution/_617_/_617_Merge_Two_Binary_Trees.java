package solution._617_;

import models.TreeNode;

/**
 * Author: Sorcerer
 * Date: 2018/4/26
 * Description:
 */
public class _617_Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            TreeNode node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
            return node;
        }
        if (t1 == null && t2 != null) {
            TreeNode node = new TreeNode(t2.val);
            node.left = mergeTrees(null, t2.left);
            node.right = mergeTrees(null, t2.right);
            return node;
        }
        if (t1 != null && t2 == null) {
            TreeNode node = new TreeNode(t1.val);
            node.left = mergeTrees(t1.left, null);
            node.right = mergeTrees(t1.right, null);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
