package src.leetcode.listnode;

import java.util.Stack;

public class ReverseNodeFromEndToStart {
    public static void main() {

    }

    public ListNode ReverseNodeFromEndToStartWithSpecCount
            (ListNode root, int num) {
        //先获取整个链表的长度
        int listLength = getListLength(root);

        //如果链表长度小于１或翻转间隔值非法，直接返回原链表
        if (listLength <= 1 || num < 0) {
            return root;
        }

        int gapCount = 1;

        if (num > 1) {
            gapCount = listLength % num;
        }

        return reverseNodeWithGapFromEnd(root, num, gapCount, 1);

    }

    private ListNode reverseNodeWithGapFromEnd
            (ListNode curNode, int num, int gapCount, int index) {
        if (curNode.next == null)
            return curNode;

        if (index >= gapCount) {
            Stack<ListNode> stack = new Stack<>();
            ListNode temp = curNode;
            int i = 0;

            while (i++ < num) {
                stack.push(temp);
                temp = temp.next;
            }

            ListNode head = stack.peek();
            ListNode tail = null;

            while (stack.peek() != null && (tail = stack.pop()) != null) ;

            tail.next = reverseNodeWithGapFromEnd(curNode.next, num, gapCount, 1);

            return head;
        } else {
            curNode.next = reverseNodeWithGapFromEnd(curNode.next, num, gapCount, index + 1);
        }

        return curNode;
    }

    private int getListLength(ListNode node) {
        if (node == null) {
            return 0;
        }

        int count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }

        return count;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
