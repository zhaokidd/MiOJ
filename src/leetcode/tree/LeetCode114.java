package src.leetcode.tree;
/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * */
public class LeetCode114 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        //1.将根节点的左子树指向根节点的右节点
        //2.将根节点的右子树指向新右子树的最右节点
        //3.Loop
        if (root == null) {
            return;
        }

        TreeNode leftRoot = null;
        TreeNode rightRoot = null;

        while (root != null) {
            leftRoot  = root.left;
            rightRoot = root.right;

            //如果根节点的左子树不为空,将左子树转移至右边
            if (leftRoot != null) {
                root.right = leftRoot;
                root.left  = null;

                //找到左子树的最右节点，并将右子树连接到该节点的右节点上
                if (rightRoot != null) {
                    TreeNode temp = leftRoot;
                    while (temp.right != null) temp = temp.right;
                    temp.right = rightRoot;
                }

            }

            //更新root节点
            if (leftRoot != null) {
                root = leftRoot;
            } else {
                root = rightRoot;
            }
        }
    }

}
