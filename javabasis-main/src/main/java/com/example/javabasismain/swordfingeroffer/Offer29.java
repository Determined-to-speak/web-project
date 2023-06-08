package com.example.javabasismain.swordfingeroffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Offer29 {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = new int[][]{{3}, {2}};
        System.out.println(Arrays.toString(spiralOrder(matrix1)));
        System.out.println(Arrays.toString(spiralOrder(matrix2)));
        System.out.println(Arrays.toString(spiralOrder(matrix3)));
    }


    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int[] order = new int[rows * colums];
        int index = 0;
        int left = 0, right = colums - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                order[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                order[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    order[index++] = matrix[bottom][i];
                }
                for (int i = bottom; i > top; i--) {
                    order[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
