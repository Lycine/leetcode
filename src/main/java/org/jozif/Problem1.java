package org.jozif;

public class Problem1 {
    /**
     * 给定一个整数数列，找出其中和为特定值的那两个数。
     * <p>
     * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[i] + nums[j + i] == target) {
//                    System.out.println("true num1: " + nums[i] + "num2: " + nums[j+i] +"{"+i+","+j+i+"}");
                    return new int[]{i, j + i};
                }
//                else {
//                    System.out.println("num1: " + nums[i] + "num2: " + nums[j+i]);
//                }
            }
        }
        return null;
    }
}

