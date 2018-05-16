import models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */
public class _637_Average_of_Levels_in_Binary_Tree {

    private long[] mNodesCount, mNodesSum;
    private static final int MAXN = 10000;

    private void visit(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        mNodesCount[deep]++;
        mNodesSum[deep] += root.val;
        visit(root.left, deep + 1);
        visit(root.right, deep + 1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        mNodesCount = new long[MAXN];
        mNodesSum = new long[MAXN];
        visit(root, 1);
        List<Double> list = new ArrayList<>();
        for (int i = 1; i < MAXN; i++) {
            if (mNodesCount[i] == 0) {
                break;
            }
            list.add(1.0 * mNodesSum[i] / mNodesCount[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        _637_Average_of_Levels_in_Binary_Tree solution = new _637_Average_of_Levels_in_Binary_Tree();
        System.out.println(solution.averageOfLevels(
                TreeNode.build(new int[]{2147483647, 2147483647, 2147483647})
        ));
    }
}
