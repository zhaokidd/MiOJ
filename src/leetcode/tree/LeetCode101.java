package src.leetcode.tree;

public class LeetCode101 {
    public static void main(String[] args){

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricInner(root.left, root.right);
    }

    private boolean isSymmetricInner(TreeNode leftNode, TreeNode rightNode) {
        //如果节点均为空,则视作相等
        if (leftNode == null && rightNode == null) {
            return true;
        }
        //如果只有一个节点为空,视作不相等
        else if (leftNode == null || rightNode == null) {
            return false;
        }
        //节点值不相,视作不相等
        else if (leftNode.val != rightNode.val) {
            return false;
        }

        return isSymmetricInner(leftNode.left, rightNode.right)
                && isSymmetricInner(leftNode.right, rightNode.left);
    }
}
