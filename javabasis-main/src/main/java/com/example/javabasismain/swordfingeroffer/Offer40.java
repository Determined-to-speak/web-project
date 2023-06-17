package com.example.javabasismain.swordfingeroffer;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Offer40 {
    public static void main(String[] args) {
        int[] test1 = new int[]{3, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(test1, 2)));
        int[] test2 = new int[]{0, 1, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(test2, 1)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        heapSort(arr, k);
        int[] result = new int[k];
        for (int i = arr.length - 1, j = 0; i > arr.length - 1 - k && j < k; i--, j++) {
            result[j] = arr[i];
        }
        return result;
    }

    /**
     * O(k*logn)
     * 小顶堆排序   从大到小是小顶堆，堆顶元素需要和最后一个元素交换
     * 下标为i的节点下标的父节点下标 (i-1)/2
     * 下标为i的节点左孩子的下标 i*2+1
     * 下标为i的节点右孩子的下标 i*2+2
     *
     * @param arr
     * @param k
     */
    public static void heapSort(int[] arr, int k) {
        //建堆   先建立出来一个小顶堆，这里需要注意，建堆的时候的第一个元素需要是一个父节点元素，下标为 (n-1-1)/2
        int i;
        for (i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        //排序
        for (int j = arr.length - 1; j > arr.length - 1 - k && j > 0; j--) {
            swap(arr, j, 0);
            heapify(arr, j, 0);
        }
    }


    /**
     * 维护堆的性质 O(logn)
     *
     * @param arr 数组
     * @param n   数组长度，使用此参数可以控制不使用之前排过的堆顶元素
     * @param i   需要维护节点的下标
     */
    public static void heapify(int[] arr, int n, int i) {
        int current = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] < arr[current]) {
            current = left;
        }
        if (right < n && arr[right] < arr[current]) {
            current = right;
        }
        if (current != i) {
            swap(arr, current, i);
            heapify(arr, n, current);
        }
    }

    public static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
