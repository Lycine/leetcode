package org.jozif;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class Driver {
    public static void main(String[] args) {
        new Driver().run();
    }

    public void run() {
        long start = System.nanoTime();
//        Problem1();
        Problem2();
        long end = System.nanoTime();
        System.out.println("执行时间为" + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
    }

    public void Problem1() {
        Problem1 problem1 = new Problem1();
        problem1.twoSum1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
//        problem1.twoSum1(new int[]{3,3},6);
    }

    public void Problem2(){
        Problem2 problem2 = new Problem2();
//        problem2.ArrayToListNode(new int[]{1,2,3,4,5});

        Problem2.ListNode l1 = problem2.ArrayToListNode(new int[]{2,4,3});
        Problem2.ListNode l2 =problem2.ArrayToListNode(new int[]{5,6,4});
        //expect [7,0,8]

//        Problem2.ListNode l1 = problem2.ArrayToListNode(new int[]{1,8});
//        Problem2.ListNode l2 =problem2.ArrayToListNode(new int[]{0});
        //expect [1,8]

//        Problem2.ListNode l1 = problem2.ArrayToListNode(new int[]{9,8});
//        Problem2.ListNode l2 =problem2.ArrayToListNode(new int[]{1});
        //expect [0,9]
        problem2.addTwoNumbers2(l1,l2);
    }
}