package com.example.javabasismain.swordfingeroffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class Offer33 {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        int root = postorder[postorder.length - 1];
        int i = 0;
        for (; i < postorder.length - 1; i++) {
            if (postorder[i] > root) break;
        }

        int j = i;
        for (; j < postorder.length - 1; j++) {
            if (postorder[j] < root) return false;
        }

        int[] left = new int[i];
        System.arraycopy(postorder, 0, left, 0, i);
        int[] right = new int[postorder.length - i - 1];
        System.arraycopy(postorder, i, right, 0, postorder.length - i - 1);

        return verifyPostorder(left) && verifyPostorder(right);
    }


}
