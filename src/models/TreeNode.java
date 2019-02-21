package models;

/**
 * @author Sorcerer
 * @date 2016/1/6 0006
 */
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int x) {
        val = x;
    }

    public void inOrderQuery() {
        doInOrderQuery(this);
        System.out.println();
    }

    private static void doInOrderQuery(TreeNode node) {
        if (node == null) {
            System.out.print(" #");
            return;
        }
        doInOrderQuery(node.left);
        System.out.print(" " + node.val);
        doInOrderQuery(node.right);
    }

    private static TreeNode build(int idx, Integer[] list) {
        if (idx > list.length || list[idx - 1] == null) {
            return null;
        }
        TreeNode root = new TreeNode(list[idx - 1]);
        root.left = build(idx * 2, list);
        root.right = build(idx * 2 + 1, list);
        return root;
    }

    public static TreeNode build(Integer[] levelOrderList) {
        return build(1, levelOrderList);
    }

}
