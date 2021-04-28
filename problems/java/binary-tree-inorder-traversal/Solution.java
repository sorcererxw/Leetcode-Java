package solution._94_;

import models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/26
 * Description:
 */
public class Solution {
    private List<Integer> mList;

    private void tranversal(TreeNode root) {
        if (root == null) {
            return;
        }
        tranversal(root.left);
        mList.add(root.val);
        tranversal(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        mList = new ArrayList<>();
        tranversal(root);
        return mList;
    }

    public static void main(String[] args) {

    }
}
