package src.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层次遍历，自下而上，自右向左
 *
 * 解题思路：
 * 1.使用队列进行迭代．
 * 2.使用队列进行递归
 */
public class LeetCode107 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        int depth = 0;
        levelOrderBottomInner(res,depth,root);
        return res;
    }

    private static void levelOrderBottomInner(List<List<Integer>> res, int depth, TreeNode root) {
        //如果节点为空，则返回
        if (root == null) return;
        //头插一个队列存储本层的节点
        if (res.size() == depth) res.add(0, new ArrayList<Integer>());
        //添加当前节点到队列中
        res.get(res.size() - depth - 1).add(root.val);

        depth++;
        //递归左子节点
        levelOrderBottomInner(res, depth, root.left);
        //递归右子节点
        levelOrderBottomInner(res, depth, root.right);
    }

}
