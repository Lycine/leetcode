package org.jozif;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Problem2Test {

    private Problem2 problem2;

    @Before
    public void init() {
        problem2 = new Problem2();
    }

    @After
    public void destroy() {

    }

    @Test
    public void case1() {
        run(new int[]{3, 7}, new int[]{9, 2}, new int[]{2, 0, 1});
    }

    @Test
    public void case2() {
        run(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8});
    }

    @Test
    public void case3() {
        run(new int[]{1, 8}, new int[]{0}, new int[]{1, 8});
    }

    @Test
    public void case4() {
        run(new int[]{9, 8}, new int[]{1}, new int[]{0, 9});
    }

    @Test
    public void case6() {
        run(new int[]{9, 1, 6}, new int[]{0}, new int[]{9, 1, 6});
    }

    @Test
    public void case5() {
        run(new int[]{5}, new int[]{5}, new int[]{0, 1});
    }



    public void run(int[] l1Int, int[] l2Int, int[] expectResultInt) {
        System.out.println("-------START-------");
        //数组转链表
        Problem2.ListNode l1 = problem2.ArrayToListNode(l1Int);
        Problem2.ListNode l2 = problem2.ArrayToListNode(l2Int);
        int[] expectResult = expectResultInt;

        //执行算法
        long start = System.nanoTime();
        Problem2.ListNode lResult = problem2.addTwoNumbers1(l1, l2);
        long end = System.nanoTime();

        //结果链表转list
        List<Integer> listResult = problem2.ListNodeToList(lResult);
        //预期int数组转Integer数组
        Integer[] expectResultIntArray = ArrayUtils.toObject(expectResult);
        //Integer数组转list
        List<Integer> expectResultIntList = Arrays.asList(expectResultIntArray);
        System.out.println("预期结果: " + expectResultIntList.toString());

        //断言两个list是不是相等
        Assert.assertEquals(expectResultIntList.toString(), listResult.toString());
        System.out.println("执行时间: " + TimeUnit.NANOSECONDS.toNanos(end - start)/1000000.0 + "ms");
        System.out.println("--------END--------");
    }
}
