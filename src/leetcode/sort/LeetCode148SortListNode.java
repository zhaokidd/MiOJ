package src.leetcode.sort;

public class LeetCode148SortListNode {
    public ListNode sortList(ListNode head) {
        int listLength = getListLength(head);
        for (int i = 1; i <= (listLength + 1) / 2; i *= 2) {
            head = sortListInner(head, i);
        }

        return head;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    private ListNode sortListInner(ListNode head, int gapLength) {
        for (int i = 0; i < gapLength; i++) {

        }
        return null;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
