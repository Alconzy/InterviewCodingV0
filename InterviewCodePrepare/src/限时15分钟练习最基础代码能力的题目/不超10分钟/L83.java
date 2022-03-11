package 限时15分钟练习最基础代码能力的题目.不超10分钟;

public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = head, prev = head, fast = head.next;
        while (fast != null) {
            if (fast.value != prev.value) {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
                prev = prev.next;
            }
            while(fast != null && fast.value == prev.value) {
                fast = fast.next;
                prev = prev.next;
            }
        }
        //todo 第一次做犯错 忘记了这个!! 错例 【1，2，3，3】 expect [1,2,3] but got [1,2,3,3]
        slow.next = null;
        return dummy.next;
    }
}
