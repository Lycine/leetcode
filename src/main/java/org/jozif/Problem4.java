package org.jozif;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    /**
     * 有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。
     * <p>
     * 请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 中位数是 2.0
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 中位数是 (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int[] nums3 = new int[totalSize / 2 + 1];
        for (int i = 0, j = 0, k = 0; k < nums3.length; ++k) {
            if (i < nums1.length && j < nums2.length) {
                nums3[k] = Math.min(nums1[i], nums2[j]);
                if (nums3[k] == nums1[i]) {
                    i += 1;
                } else {
                    j += 1;
                }
            } else if (i < nums1.length && !(j < nums2.length)) {
                nums3[k] = nums1[i];
                i += 1;
//            } else if (!(i < nums1.length) && j < nums2.length) {
            } else {
                nums3[k] = nums2[j];
                j += 1;
            }
        }
        if (totalSize % 2 == 1) {
            //奇数
            return nums3[nums3.length-1];
        } else {
            //偶数
            return (nums3[nums3.length-2] + nums3[nums3.length -1]) / 2.0;
        }
    }
}
