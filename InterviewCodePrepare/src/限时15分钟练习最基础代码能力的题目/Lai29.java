package 限时15分钟练习最基础代码能力的题目;

//https://app.laicode.io/app/problem/29
public class Lai29 {
    public ListNode mergeSort(ListNode head) {
        //corner case
        if (head == null || head.next == null)
            return head;
        //find the mid
        ListNode mid = findMid(head);
        //split the linkedlist into two
        ListNode pivot = mid.next;
        mid.next = null;

        //sort
        ListNode first = mergeSort(head);
        ListNode second = mergeSort(pivot);

        return merge(first, second);
    }

    //todo 曾经犯错
    public ListNode findMid(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        //todo 一直模糊不清 不知道 该判断什么时候不能为null 在这题上 曾犯错
        // 例子 1->2
        /**
         while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         }
         **/

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode first, ListNode second) {
        //two pointers,
        ListNode cur = new ListNode(-1);
        ListNode dummyNode = cur;
        while (first != null && second != null) {
            if (first.value <= second.value) {
                cur.next = first;
                first = first.next;
            }else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first != null) {
            cur.next = first;
        }
        if (second != null) {
            cur.next = second;
        }
        return dummyNode.next;
    }
}
