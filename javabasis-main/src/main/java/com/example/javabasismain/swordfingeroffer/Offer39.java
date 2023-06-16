package com.example.javabasismain.swordfingeroffer;


/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class Offer39 {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length >> 1];
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int result = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[j] >= result && i < j) {
                j--;
            }
            while (nums[i] <= result && i < j) {
                i++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[low] = nums[i];
        nums[i] = result;
        if (i == (nums.length >> 1)) {
            return;
        }
        if (i > (nums.length >> 1)) {
            quickSort(nums, low, j - 1);
        }
        if (i < (nums.length >> 1)) {
            quickSort(nums, j + 1, high);
        }
    }
}
