package 限时15分钟练习最基础代码能力的题目;

public class Lai38CycleNodeInLinkedList {
    public ListNode cycleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            /**
             * 曾经写错 debug 好久
             *             //meet
             *             if (slow == fast) {
             *                 slow = head;
             *                 while (slow != fast) {
             *                     slow = slow.next;
             *                     fast = fast.next;
             *                 }
             *                 return slow;
             *             }
             *             //todo 这个顺序很重要！！！
             *             slow = slow.next;
             *             fast = fast.next.next;
             */
            slow = slow.next;
            fast = fast.next.next;
            //meet
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        //when reach here, not cycle;
        return null;
    }
}
