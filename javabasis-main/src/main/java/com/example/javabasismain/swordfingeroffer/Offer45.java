package com.example.javabasismain.swordfingeroffer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Offer45 {

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
        System.out.println(minNumber(new int[]{3, 30, 34, 5, 9}));
    }


    /**
     * 其实就是基本的排序算法题   可以使用冒泡排序或者快速排序
     *
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        String[] nums_str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_str[i] = String.valueOf(nums[i]);
        }

        quickSort(nums_str, 0, nums.length - 1);
        return String.join("", nums_str);
    }

    private static void quickSort(String[] nums, int left, int right) {
        if (left >= right) return;
        String flag = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i <= j && (nums[i] + flag).compareTo(flag + nums[i]) <= 0) {
                i++;
            }
            while (i <= j && (nums[j] + flag).compareTo(flag + nums[j]) >= 0) {
                j--;
            }
            if (i >= j) break;
            String temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[j];
        nums[j] = flag;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }
}
