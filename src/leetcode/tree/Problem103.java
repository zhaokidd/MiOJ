package src.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * <p>
 * 解题思路:
 * 当层元素按照队列放置,从末尾取元素并取出其左右子节点放入nextQueue中.
 */
public class Problem103 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        int traversalDirection = 0;//层级遍历顺序. 0:从左向右遍历 1:从右向左遍历

        if (root == null) {
            return resultList;
        }

        queue.addLast(root);

        while (queue.size() > 0) {
            List<Integer> curList = new ArrayList<>();
            TreeNode node;

            while ((node = queue.pollLast()) != null) {
                curList.add(node.val);
                //层级顺序遍历队列
                if (traversalDirection == 0) {
                    if (node.left != null) {
                        nextQueue.addLast(node.left);
                    }
                    if (node.right != null) {
                        nextQueue.addLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextQueue.addLast(node.right);
                    }
                    if (node.left != null) {
                        nextQueue.addLast(node.left);
                    }
                }
            }

            //把当前层遍历结果加入到集合中
            resultList.add(curList);

            //修改下层遍历方向
            if (traversalDirection == 0) {
                traversalDirection = 1;
            } else {
                traversalDirection = 0;
            }

            //把下层元素添加到当前队列中
            while (nextQueue.peekFirst() != null) {
                queue.addLast(nextQueue.pollFirst());
            }
        }

        return resultList;
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
