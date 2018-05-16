import models.TreeNode;

import java.util.Stack;

/**
 * Author: Sorcerer
 * Date: 2018/4/28
 * Description:
 */
public class _173_Binary_Search_Tree_Iterator {
    private class BSTIterator {

        private Stack<TreeNode> mStack;

        private TreeNode mNode;

        public BSTIterator(TreeNode root) {
            mStack = new Stack<>();
            mNode = root;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return mNode != null || !mStack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            while (mNode != null) {
                mStack.push(mNode);
                mNode = mNode.left;
            }
            if (!mStack.isEmpty()) {
                mNode = mStack.pop();
                int result = mNode.val;
                mNode = mNode.right;
                return result;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
//        BSTIterator iterator = new BSTIterator();
    }
}
