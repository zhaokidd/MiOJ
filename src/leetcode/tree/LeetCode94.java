package src.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 用迭代形式完成.
 *
 * 中序遍历的过程步骤(迭代法):
 * 1.取当前节点的左子树一直到最左端,并将节点入栈
 * 2.弹出栈顶节点并输出该节点的信息
 * 3.取该元素的右节点并入栈
 * 4.重复步骤1
 */
public class LeetCode94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            temp = stack.pop();
            resultList.add(temp.val);
            temp = temp.right;
        }

        return resultList;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
