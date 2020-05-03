package src.leetcode.tree;

public class LeetCode226ReverseBinaryTree {
    public static void main(String[] args){

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        invertTreeInner(root.left, root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    private void invertTreeInner(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;

        invertTreeInner(left == null ? null : left.left, right == null ? null : right.right);
        invertTreeInner(left == null ? null : left.right, right == null ? null : right.left);

        if (left != null) {
            TreeNode temp = left.left;
            left.left = left.right;
            left.right = temp;
        }

        if (right != null) {
            TreeNode temp = right.right;
            right.right = right.left;
            right.left = temp;
        }

    }

    private void swapTreeNode(TreeNode node1, TreeNode node2) {

    }
}
