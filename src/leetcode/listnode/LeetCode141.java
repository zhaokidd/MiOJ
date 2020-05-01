package src.leetcode.listnode;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 * 解题思路：使用快慢指针，一个快指针和一个慢指针，同时绕环.
 *
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (cur == next)
                return true;

            if (cur.next == null || next.next == null)
                return false;

            cur = cur.next;
            next = next.next.next;
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
