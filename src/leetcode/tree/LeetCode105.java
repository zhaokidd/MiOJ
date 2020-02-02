package src.leetcode.tree;

import java.util.HashMap;

/**
 * 由前序及中序遍历结果构造二叉树
 *
 * */
public class LeetCode105 {
    private HashMap<Integer, Integer> mInOrderIndexMap = new HashMap<>();//存储中序遍历结果的索引信息
    private int mPreOrderIndex = 0;//遍历前序数组的索引

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            mInOrderIndexMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeInternal(preorder, inorder, 0, preorder.length-1);
        return root;
    }

    private TreeNode buildTreeInternal(int[] preorder, int[] inorder, int left, int right) {
        if(left > right ) {
            return null;
        }


        TreeNode root = new TreeNode(preorder[mPreOrderIndex]);

        //确定前序元素在中序序列中的位置
        int inOrderIndex = mInOrderIndexMap.get(root.val);

        //确定根节点的左右子树index范围，并递归求出左右子节点.
        mPreOrderIndex++;
        root.left = buildTreeInternal(preorder, inorder, left, inOrderIndex-1);
        root.right = buildTreeInternal(preorder, inorder, inOrderIndex + 1, right);
        return root;
    }


    public static void main(String[] args) {

    }

}
