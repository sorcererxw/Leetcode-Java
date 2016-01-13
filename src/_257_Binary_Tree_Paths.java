import models.TreeNode;
import util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/13 0013.
 * <p>
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class _257_Binary_Tree_Paths {

    public static void main(String[] args) {
//        System.out.println(binaryTreePaths(Utility.generateTreeNodeTree(new Integer[]{1, 2})));
    }

    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            generate("" + root.val, root);
        }
        return list;
    }

    private void generate(String s, TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        if (root.left != null)
            generate(s + "->" + root.left.val, root.left);
        if (root.right != null)
            generate(s + "->" + root.right.val, root.right);
    }
}
