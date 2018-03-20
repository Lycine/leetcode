package org.jozif;

public class Problem2 {
    /**
     * 给定两个非空链表来代表两个非负数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode lHead = new ListNode(0);
        ListNode lRear = lHead;
        ListNode lCurr = new ListNode(0);
        int nextValue = 0;
        while (l1 != null && l2 != null) {
            int value = 0;
            lCurr = new ListNode(nextValue);
            nextValue = 0;
            if (l1.val + l2.val >= 10) {
                lCurr.val += (l1.val + l2.val) % 10;
                nextValue = 1;
            } else {
                lCurr.val += l1.val + l2.val;
            }

            lRear.next = lCurr;
            lRear = lRear.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (nextValue == 1) {
            if (l1 != null) {
                if (l1.val + nextValue >= 10){
                    lCurr = new ListNode(0);
                    nextValue = 1;
                    lRear.next = lCurr;
                    lRear = lRear.next;
                } else {
                    lCurr = new ListNode(l1.val+1);
                    lRear.next = lCurr;
                    lRear = lRear.next;
                    nextValue = 0;
                }

            }
            if (l2 != null) {
                if (l2.val + nextValue >= 10){
                    lCurr = new ListNode(0);
                    nextValue = 1;
                    lRear.next = lCurr;
                    lRear = lRear.next;
                } else {
                    lCurr = new ListNode(l2.val+1);
                    lRear.next = lCurr;
                    lRear = lRear.next;
                    nextValue = 0;
                }

            }
        }


        if (l1 != null) {
            lCurr = new ListNode(l1.val);
            lRear.next = lCurr;

        }
        if (l2 != null) {
            lCurr = new ListNode(l2.val);
            lRear.next = lCurr;

        }


        return lHead.next;
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode ArrayToListNode(int[] array) {
        ListNode lHead = new ListNode(0);
        ListNode lRear = lHead;
        for (int i = 0; i < array.length; i++) {
            lRear.next = new ListNode(array[i]);
            lRear = lRear.next;
        }
        return lHead.next;
    }
}
