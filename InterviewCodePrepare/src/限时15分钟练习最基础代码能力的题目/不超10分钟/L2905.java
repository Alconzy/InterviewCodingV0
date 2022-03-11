package 限时15分钟练习最基础代码能力的题目.不超10分钟;

import Leetcode.Medium600.LinkedList.ListNode;

public class L2905 {
    public Leetcode.Medium600.LinkedList.ListNode deleteMiddle(Leetcode.Medium600.LinkedList.ListNode head) {
        if (head == null || head.next == null)
            return null;

        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        //
        Leetcode.Medium600.LinkedList.ListNode dummy = new Leetcode.Medium600.LinkedList.ListNode(-1);
        Leetcode.Medium600.LinkedList.ListNode slow = head, fast = head;
        dummy.next = head;
        ListNode prev = dummy;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            prev = prev.next;
        }
        //even
        //曾犯错 if 的处理 和 else 的处理 两个位置搞反了
        if (fast.next != null) {
            //todo 曾犯错 slow.next = fast.next; 愚蠢至极！
            slow.next = slow.next.next;

        }else {
            prev.next = slow.next;
        }
        //odd
        return dummy.next;
    }
}
