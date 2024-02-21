package com.example.javabasismain.swordfingeroffer.util;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtil {


    /**
     * 层次遍历
     *
     * @param root
     */
    public static void levelTrav(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode cur;
        while (!q.isEmpty()) {
            cur = q.peek();

            if (cur.val == Integer.MIN_VALUE) {
                System.out.print("null ");
                q.poll();
                continue;
            } else {
                System.out.print(cur.val + " ");
            }

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.left == null) {
                q.add(new TreeNode(Integer.MIN_VALUE));
            }

            if (cur.right != null) {
                q.add(cur.right);
            }
            if (cur.right == null) {
                q.add(new TreeNode(Integer.MIN_VALUE));
            }
            q.poll();
        }

//        int[] result = new int[resultList.size()];
//        int index = 0;
//        for (TreeNode treeNode : resultList) {
//            if (treeNode == null) {
//                result[index] = Integer.MIN_VALUE;
//            } else {
//                result[index] = treeNode.val;
//            }
//            index++;
//        }
//        return result;

    }

}
