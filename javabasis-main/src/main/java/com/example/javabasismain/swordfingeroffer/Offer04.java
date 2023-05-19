package com.example.javabasismain.swordfingeroffer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer04 {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] matrix = new int[][]{{-5}};

        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray(matrix, 20));
        System.out.println(findNumberIn2DArray(matrix, -5));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        for (int nIndex = 0; nIndex < n; nIndex++) {
            boolean flag = false;
            int flagMIndex = 0;
            for (int mIndex = m - 1; mIndex >= 0 && !flag; mIndex--) {

                int current = matrix[nIndex][mIndex];
                if (target == current) return true;
                if (target > current) {
                    flagMIndex = mIndex;
                    flag = true;
                }

            }

            if (flag) {
                int current = matrix[nIndex][flagMIndex];
                if (target == current) return true;
            }
        }
        return false;
    }

}
