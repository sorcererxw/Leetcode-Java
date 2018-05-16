import models.TreeNode;

/**
 * Author: Sorcerer
 * Date: 2018/4/27
 * Description:
 */
public class _114_Flatten_Binary_Tree_to_Linked_List {
    private TreeNode flat(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        root.left = null;
        root.right = left;
        TreeNode t = root;
        while (t.right != null) {
            t = t.right;
        }
        t.right = right;
        return root;
    }

    public void flatten(TreeNode root) {
        flat(root);
    }
}
