package org.jozif;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Problem3Test {

    private Problem3 problem3;

    @Before
    public void init() {
        problem3 = new Problem3();
    }

    @After
    public void destroy() {

    }

    @Test
    public void case1() {
        run("abcabcbb", 3);
    }

    @Test
    public void case2() {
        run("bbbbb", 1);
    }

    @Test
    public void case3() {
        run("pwwkew", 3);
    }

    @Test
    public void case4() {
        run("c", 1);
    }

    @Test
    public void case5() {
        run("", 0);
    }

    @Test
    public void case6() {
        run("au", 2);
    }

    @Test
    public void case7() {
        run("aab", 2);
    }

    @Test
    public void case8() {
        run("abba", 2);
    }

    public void run(String rawString, int longestSubstring) {
        System.out.println("-------START-------");

        //执行算法
        long start = System.nanoTime();
        int result = problem3.lengthOfLongestSubstring(rawString);
        long end = System.nanoTime();

        //断言两个list是不是相等
        Assert.assertEquals(result, longestSubstring);
        System.out.println("执行时间: " + TimeUnit.NANOSECONDS.toNanos(end - start) / 1000000.0 + "ms");
        System.out.println("--------END--------");
    }
}