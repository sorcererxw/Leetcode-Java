import models.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/27
 * Description:
 */
public class _145_Binary_Tree_Postorder_Traversal {
    private List<Integer> mList;

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        travel(root.right);
        mList.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        mList = new LinkedList<>();
        travel(root);
        return mList;
    }
}
