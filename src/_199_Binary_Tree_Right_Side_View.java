import models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/26
 * Description:
 */
public class _199_Binary_Tree_Right_Side_View {
    private List<Integer> mList;

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        mList.add(root.val);
        if (root.right == null) {
            travel(root.left);
        } else {
            travel(root.right);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        mList = new ArrayList<>();
        travel(root);
        return mList;
    }
}
