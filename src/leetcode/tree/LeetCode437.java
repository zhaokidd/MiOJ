package src.leetcode.tree;

import java.util.ArrayList;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class LeetCode437 {
    public int pathSum(TreeNode root, int sum) {
        ArrayList<TreeNode> list = new ArrayList<>();

        return pathSumInner1(root,sum,list);
    }

    private int pathSumInner1(TreeNode node, int sum, ArrayList<TreeNode> list) {
        if (node == null)
            return 0;
        else
            list.add(node);

        int total = 0;
        int valueCount = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            valueCount += list.get(i).val;

            if (valueCount == sum) {
                total++;
            }
        }

        total += pathSumInner1(node.left, sum, list);
        list.remove(node.left);

        total += pathSumInner1(node.right, sum, list);
        list.remove(node.right);

        return total;
    }


}
