import models.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by Sorcerer on 2016/1/6 0006.
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class _107_Binary_Tree_Level_Order_Traversal_II {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(levelOrderBottom(node));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        getList(lists, root, 0);

        Collections.reverse(lists);

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
