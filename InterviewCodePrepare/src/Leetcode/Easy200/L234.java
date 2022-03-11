package Leetcode.Easy200;

public class L234 {
    public boolean isPalindrome(ListNode head) {
        //palindrom, reverse is same as original
        ListNode mid = findMid(head);
        ListNode newHead = reverse(mid);
        while(head != null && newHead != null) {
            if (head.value != newHead.value)
                return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    public ListNode findMid(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
