package src.leetcode.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * */
public class DiameterOfBinaryTree {
    public static void main(String[] args){

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        return Math.max(depthOfNode(root),
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private static int depthOfNode(TreeNode node) {
        if (node == null)
            return 0;

        return depthOfNodeInner(node.left) + depthOfNodeInner(node.right);
    }

    private static int depthOfNodeInner(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(depthOfNodeInner(node.left), depthOfNodeInner(node.right)) + 1;
    }

}
