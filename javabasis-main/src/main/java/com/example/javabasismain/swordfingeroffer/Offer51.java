package com.example.javabasismain.swordfingeroffer;


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 * <p>
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Offer51 {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (right - left) / 2 + left;
        int x1 = mergeSort(nums, left, mid);
        int x2 = mergeSort(nums, mid + 1, right);
        int x3 = merge(nums, left, mid, mid + 1, right);

        return x1 + x2 + x3;
    }

    private static int merge(int[] nums, int left, int mid, int addmid, int right) {
        int[] temp = new int[right - left + 1];
        int count = 0;
        int i = left, j = addmid, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                count = count + (addmid - i);
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        //把临时数组复制回原数组
        k = 0;
        for (int l = left; l <= right; l++) {
            nums[l] = temp[k++];
        }
        return count;
    }
}
