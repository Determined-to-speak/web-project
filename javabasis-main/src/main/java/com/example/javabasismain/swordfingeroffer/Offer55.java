package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为 1 。
 * <p>
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b
 */
public class Offer55 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int result = 0;
        return findResult(queue, result);
    }

    public static int findResult(Queue<TreeNode> queue, int result) {
        if (queue.size() == 0) return result;
        Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
        while (queue.size() > 0) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                nextQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextQueue.add(treeNode.right);
            }
        }
        result++;
        return findResult(nextQueue, result);
    }
}
