package 限时15分钟练习最基础代码能力的题目;

//https://leetcode.com/problems/insertion-sort-list/
public class L147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        //never lost the control of head
        ListNode curr = head, dummy = new ListNode();
        //simulate for(int i = 0; i < length; i++)
        while (curr != null) {
            ListNode prev = dummy;
            while (prev.next != null && prev.next.value < curr.value) {
                prev = prev.next;
            }

            ListNode next = curr.next;
            // insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;

            // moving on to the next iteration
            curr = next;
        }
        return dummy.next;
    }
}
