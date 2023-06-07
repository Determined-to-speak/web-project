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
        System.out.println(Arrays.toString(spiralOrder(matrix1)));
        System.out.println(Arrays.toString(spiralOrder(matrix2)));
    }


    public static int[] spiralOrder(int[][] matrix) {

        int y = matrix.length;
        int x = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < x - 1) {
            int number = matrix[i][j];
            result.add(number);
            matrix[i][j] = 0;
            i++;
        }

        while (j < y - 1) {
            int number = matrix[i][j];
            result.add(number);
            matrix[i][j] = 0;
            j++;
        }

        while (i > 0) {
            int number = matrix[i][j];
            result.add(number);
            matrix[i][j] = 0;
            i--;
        }

        while (j < y - 1) {
            int number = matrix[i][j];
            result.add(number);
            matrix[i][j] = 0;
            j++;
        }

        return null;

    }
}
