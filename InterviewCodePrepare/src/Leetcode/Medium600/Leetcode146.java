package Leetcode.Medium600;

public class Leetcode146 {
    /**
     * Approach one, 自己实现LinkedHashMap
     *   https://labuladong.gitee.io/algo/2/20/45/
     */
//a node for constructing doubly linked list
    class Node<K, V> {

        K key;
        V value;
        Node<K, V> prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //todo construct a doubly linked list class
    class DoublyLinkedList {
        Node dummyHead, dummyTail;
        int size;

        public DoublyLinkedList() {
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        /**
         todo
            head (left) of doublyLinkedList: the least used
            tail (right) right of doublyLinkedList: the recent used
                therefore, below functions are used to :

            1. find the most recent
            2. find the most least
            3.
                3.1 add or
                3.2 update node to recent
                3.3 put

            **** 4. get (will be solve by hashmap in order to O(1) time complexity
         */

        //tail (last) is the most recent
        //todo
        // 注意 链表一直是 head--> headReal-->n1 --> n2 --> n3 --> tailReal --> tail
        // 有dummynode head 和 tail 这样能够简单解决空链接的边界问题
        public void addLast(Node newNode) {
         //dummyHead <----> dummyTail
            //dummyHead   newNode  dummyTail
            newNode.prev = dummyTail.prev;
            newNode.next = dummyTail;

            dummyTail.prev.next = newNode;
            dummyTail.prev = newNode;
            size++;
        }

        public void remove(Node node) {

        }

        public void removeLast() {

        }

        public int getSize() {
            return size;
        }
    }


    /**
     * Approach two, 使用Java 内置 LinkedHashMap
     */
}
