package org.jozif;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Problem5Test {

    private Problem5 problem5;

    @Before
    public void init() {
        problem5 = new Problem5();
    }

    @After
    public void destroy() {

    }

    @Test
    public void case1() {
        run("babad","bab");
    }

    @Test
    public void case2() {
        run("cbbd","bb");
    }



    public void run(String s, String longestPalindrome) {
        System.out.println("-------START-------");

        //执行算法
        long start = System.nanoTime();
        String result = problem5.longestPalindrome(s);
        long end = System.nanoTime();

        //断言两个list是不是相等
        Assert.assertEquals(result,longestPalindrome);
        System.out.println("执行时间3: " + TimeUnit.NANOSECONDS.toNanos(end - start) / 1000000.0 + "ms");
        System.out.println("--------END--------");
    }
}
