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
        Problem1();
        long end = System.nanoTime();
        System.out.println("执行时间为" + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
    }

    public void Problem1() {
        Problem1 problem1 = new Problem1();
        problem1.twoSum1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
//        problem1.twoSum1(new int[]{3,3},6);
    }
}