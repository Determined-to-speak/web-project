package com.example.javabasismain.swordfingeroffer;


import com.example.javabasismain.swordfingeroffer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class Offer32II {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> temp = new LinkedBlockingDeque<>();
        temp.offer(root);
        List<Integer> resultList = new ArrayList<>();
        findTree(temp, resultList, result);
        return result;
    }

    public static void findTree(Queue<TreeNode> temp, List<Integer> resultList, List<List<Integer>> result) {
        Queue<TreeNode> new_temp = new LinkedBlockingDeque<>();
        if (temp == null || temp.size() <= 0) {
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

        result.add(resultList);

        findTree(new_temp, new ArrayList<>(), result);
    }

}
