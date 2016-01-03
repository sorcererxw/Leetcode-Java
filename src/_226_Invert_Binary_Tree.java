import sun.reflect.generics.tree.Tree;

/**
 * Created by Sorcerer on 2016/1/3 0003.
 *
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class _226_Invert_Binary_Tree {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
