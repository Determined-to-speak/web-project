package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.ListNode;
import com.example.javabasismain.swordfingeroffer.util.TreeNode;

public class Offer27 {

    public static void main(String[] args) {

    }

    public static TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }


}
