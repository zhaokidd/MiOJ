package src.leetcode.tree;

/**
 * 求二叉树的最大深度
 * */
public class LeetCode104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return maxDepthInner(root, 0);
    }

    public int maxDepthInner(TreeNode current, int curDepth) {
        if (current == null) {
            return curDepth;
        }

        curDepth++;

        return Math.max(maxDepthInner(current.left, curDepth),
                maxDepthInner(current.right, curDepth ));
    }
}
