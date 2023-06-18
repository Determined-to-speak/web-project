package com.example.javabasismain.swordfingeroffer;


/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Offer42 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 直接动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return findResult(nums);
    }

    public static int findResult(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = result[0];
        for (int i = 1; i < nums.length; i++) {
            if (result[i - 1] <= 0) result[i] = nums[i];
            else {
                result[i] = result[i - 1] + nums[i];
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }


//    public static int maxSubArray(int[] nums) {
//        int temp = nums[0];
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (max < 0 && nums[i] < 0) {
//                max = Math.max(nums[i], max);
//                continue;
//            }
//            int current = max + nums[i];
//            if (nums[i] < 0) {
//                temp = Math.max(temp, max);
//                max = current;
//                continue;
//            }
//            if (current < nums[i]) {
//                max = nums[i];
//                continue;
//            }
//            max = current;
//        }
//        return Math.max(temp, max);
//    }

}
