package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 */
public class Offer26 {
    public static void main(String[] args) {

    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;

        return EqualTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static boolean EqualTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return EqualTree(a.left, b.left) && EqualTree(a.right, b.right);
    }
}
