package src.leetcode.tree;

import java.util.HashMap;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * */
public class LeetCode106 {
    private HashMap<Integer, Integer> mMapPostOrderIndex
            = new HashMap<>();//后序序列元素在中序序列中的位置

    private int mPostOrderCurIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //存储中序序列的位置索引
        HashMap<Integer, Integer> mInOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mInOrderIndexMap.put(inorder[i], i);
        }

        //存储后序序列元素在中序序列中的位置.
        for (int i = postorder.length - 1; i >= 0; i--) {
            mMapPostOrderIndex.put(i, mInOrderIndexMap.get(postorder[i]));
        }

        mPostOrderCurIndex = postorder.length - 1;

        return buildTreeInternal(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeInternal(int[] inOrder, int[] postOrder,
                                       int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[mPostOrderCurIndex]);
        int inOrderCurIndex = mMapPostOrderIndex.get(mPostOrderCurIndex);

        mPostOrderCurIndex--;
        root.right = buildTreeInternal(inOrder, postOrder, inOrderCurIndex + 1, endIndex);
        root.left = buildTreeInternal(inOrder, postOrder, startIndex, inOrderCurIndex - 1);

        return root;
    }
}
