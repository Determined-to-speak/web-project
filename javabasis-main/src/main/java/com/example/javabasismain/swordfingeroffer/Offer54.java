package com.example.javabasismain.swordfingeroffer;


import com.example.javabasismain.swordfingeroffer.util.TreeNode;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 * <p>
 * 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Offer54 {


    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = -1;
        }
        midOrder(result, root);
        return result[k - 1];
    }

    public static void midOrder(int[] result, TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                midOrder(result, root.left);
            }

            for (int i = 0; i < result.length; i++) {
                if (result[i] == -1) {
                    result[i] = root.val;
                    break;
                }
                if (i == result.length - 1) {
                    return;
                }
            }

            if (root.right != null) {
                midOrder(result, root.right);
            }

        }
    }
}
