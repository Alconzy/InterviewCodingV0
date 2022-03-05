package 限时15分钟练习最基础代码能力的题目;

/**
 * https://app.laicode.io/app/problem/35?plan=3
 */

public class LaiCode35reverseInPair {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null) {
            ListNode newHead = head.next;
            head.next = null;
            newHead.next = head;
            return newHead;
        }
        // Write your solution here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = next.next;
            next.next = cur.next;
            cur.next = next;

            //udpate
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
