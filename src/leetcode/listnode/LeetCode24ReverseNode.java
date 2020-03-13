package src.leetcode.listnode;

public class LeetCode24ReverseNode {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        while (newHead.next != null) {
            newHead = newHead.next;
        }

        reverseListInner(head);
        return newHead;
    }

    private void reverseListInner(ListNode node) {
        if (node.next == null) {
            return;
        }

        if (node.next.next != null) {
            reverseListInner(node.next);
        }

        ListNode temp = node.next;
        temp.next = node;
        node.next = null;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
