package 限时15分钟练习最基础代码能力的题目;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://github.com/hadyang/interview/blob/master/content/docs/leetcode/mergeKLists/index.md
public class L23 {
    /**
     * Definition for singly-linked list.
     * **/
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        //todo 学习这个用法：Queue<ListNode> set = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        //use minHeap,
        Queue<ListNode> set = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            while (node != null){
                set.add(node);
                node = node.next;
            }
        }

        //下面是直接抄的 自己错了好几个坑 最大的一个坑是 int[] lists 可以有null !  也就是null node!!!
        ListNode head = new ListNode(-1);
        ListNode res = head;
        ListNode cur;
        while ((cur = set.poll()) != null) {
            head.next = cur;
            head = head.next;
        }
        head.next = null;
        return res.next;
    }
}
