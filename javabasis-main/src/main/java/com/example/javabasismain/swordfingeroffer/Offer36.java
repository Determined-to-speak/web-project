package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.Node;
import com.example.javabasismain.swordfingeroffer.util.Node2;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class Offer36 {


    public static void main(String[] args) {

    }

    static Node2 pre, head = null;

    public static Node2 treeToDoublyList(Node2 root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        Node2 result = head;
        pre = null;
        head = null;
        return result;
    }

    private static void dfs(Node2 cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


}
