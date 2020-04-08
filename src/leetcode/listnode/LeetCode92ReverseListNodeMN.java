package src.leetcode.listnode;

import java.util.Stack;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class LeetCode92ReverseListNodeMN {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        ListNode newHead = null;
        ListNode newTail = null;
        int index = 1;

        while (current != null) {

            if (index == m - 1) {
                newHead = current;
            } else if (index == n + 1) {
                newTail = current;
            }

            if (index >= m && index <= n) {
                stack.push(current);
            }

            current = current.next;
            index++;
        }

        ListNode tempHead = null;
        ListNode tempTail = null;
        ListNode tempCurrent = null;
        if (stack.size() > 0) {
            tempCurrent = stack.pop();
            tempHead = tempCurrent;
            tempTail = tempHead;
            while (!stack.isEmpty() && stack.peek() != null) {
                tempTail = stack.pop();
                tempCurrent.next = tempTail;
                tempCurrent = tempTail;
            }
        }

        if(newHead!=null){
            newHead.next = tempHead;
        }else{
            newHead = tempHead;
        }

        if (newTail != null && tempTail != null) {
            tempTail.next = newTail;
        } else if (newTail == null && tempTail != null) {
            tempTail.next = null;
        }

        return m > 1 ? head : newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
