package com.example.javabasismain.sort;

/**
 * https://www.bilibili.com/video/BV1fp4y1D7cj/?spm_id_from=333.337.search-card.all.click&vd_source=762c708805c60f99f0744027b9b85d02
 */
public class BigHeapSort {
    public static void main(String[] args) {

    }

    /**
     * 大顶堆排序   从小到大是大顶堆，堆顶元素需要和最后一个元素交换
     * 下标为i的节点下标的父节点下标 (i-1)/2
     * 下标为i的节点左孩子的下标 i*2+1
     * 下标为i的节点右孩子的下标 i*2+2
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //建堆   先建立出来一个大顶堆----这里注意虽然是大顶堆，但还是乱序的
        int i;
        for (i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        //排序
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, j, 0);
            heapify(arr, j, 0);
        }
    }


    /**
     * 维护堆的性质 O(logn)
     *
     * @param arr 数组
     * @param n   数组长度
     * @param i   维护的下标
     */
    public static void heapify(int[] arr, int n, int i) {
        int current = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] > arr[current]) {
            current = left;
        }
        if (right < n && arr[right] > arr[current]) {
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
