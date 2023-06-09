package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class Offer32I {


    public static void main(String[] args) {

    }


    public static int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Queue<TreeNode> temp = new LinkedBlockingDeque<>();
        temp.offer(root);
        List<Integer> resultList = new ArrayList<>();
        findTree(temp, resultList);

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void findTree(Queue<TreeNode> temp, List<Integer> resultList) {
        while (temp.size() > 0) {
            TreeNode next = temp.peek();
            if (next == null) break;
            resultList.add(next.val);
            if (next.left != null) {
                temp.offer(next.left);
            }
            if (next.right != null) {
                temp.offer(next.right);
            }
            temp.poll();
        }
    }


}
