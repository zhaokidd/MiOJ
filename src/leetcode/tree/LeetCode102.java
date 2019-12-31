package src.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树按层次遍历
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 解题思路:
 * 用队列保存bfs遍历结果,每层遍历结束后在队列末尾存储分隔符标志位.
 *
 */
public class LeetCode102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfsList = new ArrayList<>();

        if (root == null) {
            return bfsList;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();

        queue.addLast(root);

        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();

            //取出所有元素的左右子节点
            while (queue.size() > 0) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    nextQueue.addLast(node.left);
                }

                if (node.right != null) {
                    nextQueue.addLast(node.right);
                }
            }

            //将当前该层的序列结果加入list队列中
            bfsList.add(list);

            //将所有下层的左右子节点添加到上层队列中
            while (nextQueue.peek() != null) {
                queue.addLast(nextQueue.pollFirst());
            }

        }

        return bfsList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
