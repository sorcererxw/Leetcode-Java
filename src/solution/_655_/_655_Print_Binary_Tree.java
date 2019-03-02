import models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/28
 * Description:
 */
public class _655_Print_Binary_Tree {

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

    private int mDeep;
    private int mWidth;
    private String[][] mMap;

    private void print(TreeNode root, int x, int y, int w, int h) {
        if (root == null) {
            return;
        }
        mMap[y][x + w / 2] = String.valueOf(root.val);
        print(root.left, x, y + 1, (w - 1) / 2, h - 1);
        print(root.right, x + w / 2 + 1, y + 1, (w - 1) / 2, h - 1);
    }

    public List<List<String>> printTree(TreeNode root) {
        mDeep = deep(root);
        mWidth = (int) (Math.pow(2, mDeep) - 1);
        mMap = new String[mDeep][mWidth];
        print(root, 0, 0, mWidth, mDeep);
        List<List<String>> lists = new ArrayList<>();
        for (String[] row : mMap) {
            List<String> list = new ArrayList<>();
            for (String item : row) {
                if (item == null) {
                    list.add("#");
                } else {
                    list.add(item);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        _655_Print_Binary_Tree solution = new _655_Print_Binary_Tree();
        List<List<String>> lists = solution.printTree(TreeNode.build(new Integer[]{1, 2, 3, -1, 4}));
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
