package src.leetcode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SameTree572 {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && null == t)
            return true;

        if (s == null || t == null)
            return false;

        List<TreeNode> allNodes = getNodes(s);
        Iterator<TreeNode> iterator = allNodes.iterator();
        while (iterator.hasNext()) {
            TreeNode curNode = iterator.next();
            if (isSubtreeInner(curNode, t) || isSubtreeInner(curNode.left, t) || isSubtreeInner(curNode.right, t))
                return true;
        }

        return false;
    }

    private List<TreeNode> getNodes(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        recursiveNodes(list,root);
        return list;
    }

    private void recursiveNodes(List<TreeNode> list,TreeNode node) {
        if (node.left != null) {
            list.add(node.left);
            recursiveNodes(list, node.left);
        }

        if (node.right != null) {
            list.add(node.right);
            recursiveNodes(list, node.right);
        }
    }

    public boolean isSubtreeInner(TreeNode s, TreeNode t) {
        if (s == null && null == t)
            return true;

        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSubtreeInner(s.left, t.left)
                && isSubtreeInner(s.right, t.right);
    }
}
