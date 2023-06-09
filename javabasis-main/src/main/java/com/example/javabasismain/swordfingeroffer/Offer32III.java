package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */

public class Offer32III {
    public static void main(String[] args) {

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> temp = new LinkedBlockingDeque<>();
        temp.offer(root);
        boolean flag = false;
        findTree(temp, new ArrayList<>(), result, flag);
        return result;
    }

    public static void findTree(Queue<TreeNode> temp, List<Integer> resultList, List<List<Integer>> result, boolean flag) {
        Queue<TreeNode> new_temp = new LinkedBlockingDeque<>();
        if (temp == null || temp.size() == 0) {
            return;
        }

        while (temp.size() > 0) {
            TreeNode next = temp.peek();
            if (next == null) break;
            resultList.add(next.val);
            if (next.left != null) {
                new_temp.offer(next.left);
            }
            if (next.right != null) {
                new_temp.offer(next.right);
            }
            temp.poll();
        }

        if (flag)
            Collections.reverse(resultList);

        flag = !flag;

        result.add(resultList);

        findTree(new_temp, new ArrayList<>(), result, flag);
    }

}
