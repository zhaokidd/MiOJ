package src.leetcode.listnode;

/***
 *
 * 判断回文子串
 * 空间复杂度O(1),时间复杂度O(n)
 * 保留头部节点，在递归回朔时判断头结点和尾节点.
 * */
public class LeetCode234ReverseListNode {
    public static void main(String[] args) {
        ListNode fir = new ListNode(1);
        ListNode sec = new ListNode(3);
        ListNode thr = new ListNode(1);
        fir.next = sec;
        sec.next = thr;

        isPalindrome(fir);
    }

    private static ListNode originHead;

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        originHead = head;
        return isPalindromeInner(head);
    }

    private static boolean isPalindromeInner(ListNode cur) {
        if (cur.next != null && isPalindromeInner(cur.next) && originHead.val == cur.val) {
            originHead = originHead.next;
            return true;
        } else if (cur.next == null) {
            int headVal = originHead.val;
            originHead = originHead.next;
            return cur.val == headVal;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
