package com.example.javabasismain.swordfingeroffer;


import com.example.javabasismain.swordfingeroffer.util.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class Offer28 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compareTwoTree(root.left, root.right);
    }

    public static boolean compareTwoTree(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return compareTwoTree(leftTree.left, rightTree.right) && compareTwoTree(leftTree.right, rightTree.left);
    }


}
