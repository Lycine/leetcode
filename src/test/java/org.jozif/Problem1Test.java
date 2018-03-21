package org.jozif;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Problem1Test {

    private Problem1 problem1;

    @Before
    public void init() {
        problem1 = new Problem1();
    }

    @After
    public void destroy() {

    }

    @Test
    public void case1() {
        run(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 17, new int[]{7, 8});
    }

    @Test
    public void case2() {
        run(new int[]{3, 3}, 6, new int[]{0, 1});
    }

    public void run(int[] nums, int target, int[] expectResultInt) {
        System.out.println("-------START-------");
        int[] expectResult = expectResultInt;

        //执行算法
        long start = System.nanoTime();
        int[] resultInt = problem1.twoSum1(nums, target);
        long end = System.nanoTime();

        //预期int数组转Integer数组
        Integer[] expectResultIntArray = ArrayUtils.toObject(expectResult);
        //结果int数组转Integer数组
        Integer[] esultIntArray = ArrayUtils.toObject(resultInt);
        //Integer数组转list
        List<Integer> expectResrultIntList = Arrays.asList(expectResultIntArray);
        List<Integer> resrultIntList = Arrays.asList(esultIntArray);
        System.out.println("预期结果: " + expectResrultIntList.toString());

        //断言两个list是不是相等
        Assert.assertEquals(expectResrultIntList.toString(), resrultIntList.toString());
        System.out.println("执行时间: " + TimeUnit.NANOSECONDS.toNanos(end - start)/1000000.0 + "ms");
        System.out.println("--------END--------");
    }
}
