package src.leetcode.tree;

import java.util.Stack;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 *
 * 解题思路：利用二叉搜索树的性质(左子节点小于根节点，右子节点大于根节点).保存二叉搜索树的前序遍历结果.
 * 找寻小于根节点的序列递归构造左子树，找寻大于根节点的序列递归构造右子树.
 *
 * */
public class LeetCode449 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = null;
        root.left.right = new TreeNode(2);

        String serialLine = serialize(root);
        System.out.println(serialLine);

        deserialize(serialLine);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return null;


        //利用栈构造树的先序遍历
        StringBuilder builder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;

        stack.push(root);
        builder.append(',');
        while (stack.size() > 0) {
            cur = stack.pop();
            if (cur != null) {
                builder.append(cur.val);
                builder.append(',');
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }

        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.toString();
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        String[] a = data.split(",");

        if (a.length <= 1) {
            return new TreeNode(Integer.valueOf(a[0]));
        }

        TreeNode root = new TreeNode((int) data.charAt(0) - '0');
        deserializeInner(root, data.substring(1));

        return root;
    }

    private static void deserializeInner(TreeNode head, String subData) {
        if (head == null) {
            return;
        }

        if (subData == null || subData.equals("")) {
            return;
        }

        int headVal = head.val;
        int left = 0;
        int right = -1;

        for (int i = 0; i < subData.length(); i++) {
            if ((int) subData.charAt(i) - '0' >= headVal) {
                right = i;
                if (right == 0) {
                    left = -1;
                }
                break;
            }
        }

        //确定左右子树的根节点
        if (left < 0) {
            head.left = null;
            head.right = new TreeNode(subData.charAt(right) - '0');
        } else if (left == 0 && right < 0) {
            head.right = null;
            head.left = new TreeNode(subData.charAt(left) - '0');
        } else if (right > 0) {
            head.left = new TreeNode(subData.charAt(left) - '0');
            head.right = new TreeNode(subData.charAt(right) - '0');
        } else if (right == 0) {
            head.left = null;
            head.right = new TreeNode(subData.charAt(right) - '0');
        }

        if (left >= 0 && right >= 0) {
            deserializeInner(head.left, subData.substring(left + 1, right));
        }

        if(right>=0){
            deserializeInner(head.right, subData.substring(right + 1));
        }

    }
}
