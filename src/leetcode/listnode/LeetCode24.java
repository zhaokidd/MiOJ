package src.leetcode.listnode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        return swapPairsInner(head);
    }

    private ListNode swapPairsInner(ListNode node) {
        if (node != null && node.next != null) {
            ListNode nextPairFir = swapPairsInner(node.next.next);
            ListNode curPairSec = node.next;
            curPairSec.next = node;
            node.next = nextPairFir;
            return curPairSec;
        } else {
            return node;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
