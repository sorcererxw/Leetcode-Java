import models.TreeNode;

/**
 * Author: Sorcerer
 * Date: 2018/4/26
 * Description:
 */
public class _814_Binary_Tree_Pruning {
    private TreeNode prune(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = prune(root.left);
        root.right = prune(root.right);
        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            } else {
                return root;
            }
        } else {
            return root;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }

    public static void main(String[] args) {

    }
}
