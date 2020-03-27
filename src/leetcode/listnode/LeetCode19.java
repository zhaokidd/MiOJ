package src.leetcode.listnode;

/**
 * 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class LeetCode19 {
    static int count=0;
    static int curLength = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        count = 0;
        curLength = 0;
        return removeNthFromEndInner(head, n);
    }

    private ListNode removeNthFromEndInner(ListNode head, int n) {
        curLength++;
        if (head.next != null) removeNthFromEndInner(head.next, n);
        count++;
        if (count == n + 1) {
            ListNode next = head.next;
            if (next != null) {
                head.next = next.next;
            } else {
                head.next = null;
            }
            return head;
        } else if (count == n && n == curLength) {
            return head.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
