package Leetcode.Medium600.LinkedList;

import java.util.LinkedList;

public class L143 {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.offerLast(temp);
            temp = temp.next;
        }

        temp = head;
        while (!stack.isEmpty()) {
            ListNode next = temp.next;
            ListNode end = stack.pollLast();
            temp.next = end;
            end.next = next;
            temp = next;
           // temp = temp.next.next; //曾犯错 temp = next; 会报cycle！！不懂原因
            if (temp == end) {
                temp.next = null;
                break;
            }
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);


        reorderList(head);
    }
}
