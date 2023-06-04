package com.example.javabasismain.swordfingeroffer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * <p>
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Offer21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    public static int[] exchange(int[] nums) {
       return new_exchange(nums,Offer21::isOdd);
    }

    public static int[] new_exchange(int[] nums, Function<Integer, Boolean> fn) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            while (left < right && fn.apply(nums[left])) {
                left++;
            }

            while (left < right && !fn.apply(nums[right])) {
                right--;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

        }
        return nums;
    }

    public static boolean isOdd(int i) {
        return (i & 1) == 1;
    }
}
