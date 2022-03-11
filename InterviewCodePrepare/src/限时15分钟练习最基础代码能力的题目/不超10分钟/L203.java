package 限时15分钟练习最基础代码能力的题目.不超10分钟;

public class L203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        while (head != null) {
            if (head.value == val) {
                prev.next = head.next;
            }
            else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
