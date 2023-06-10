package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 给你二叉树的根节点root和一个整数目标和 targetSum，找出所有从根节点到叶子节点 路径总和等于给定目标和的路径
 * <p>
 * <p>
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Offer34 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int countSum = 0;
        List<Integer> currentList = new ArrayList<>();
        findPath(root, target, countSum, currentList, result);
        return result;
    }

    public static void findPath(TreeNode root, int target, int countSum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        int newCountSum = countSum + root.val;
        if (root.left == null && root.right == null && target == newCountSum) {
            result.add(new ArrayList<>(list));
        }

        if (root.left != null) {
            findPath(root.left, target, newCountSum, list, result);
        }
        if (root.right != null) {
            findPath(root.right, target, newCountSum, list, result);
        }
        list.remove(list.size() - 1);

    }
}
