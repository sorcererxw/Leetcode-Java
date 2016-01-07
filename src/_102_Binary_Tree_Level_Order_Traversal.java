import models.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/7 0007.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class _102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        getList(lists, root, 0);

        return lists;
    }

    private static void getList(List<List<Integer>> lists, TreeNode node, int step) {
        if (node == null) {
            return;
        }
        List list;
        if(lists.size()<=step){
            list= new ArrayList<>();
            lists.add(list);
        }else{
            list = lists.get(step);
        }
        list.add(node.val);
        getList(lists, node.left, step + 1);
        getList(lists, node.right, step + 1);
    }
}
