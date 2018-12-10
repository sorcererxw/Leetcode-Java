import models.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/27
 * Description:
 */
public class _144_Binary_Tree_Preorder_Traversal {
    private List<Integer> mList;

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        mList.add(root.val);
        travel(root.left);
        travel(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        mList = new LinkedList<>();
        travel(root);
        return mList;
    }
}
