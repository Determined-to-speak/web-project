package com.example.javabasismain.swordfingeroffer;


import com.example.javabasismain.swordfingeroffer.util.TreeNode;
import com.example.javabasismain.swordfingeroffer.util.TreeNodeUtil;
import org.apache.commons.lang3.ArrayUtils;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * Input: preorder = [3,9,20,15,7],
 * inorder = [9,3,15,20,7],
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer07 {

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNodeUtil.levelTrav(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = null;
        for (int i = 0; i < preorder.length; i++) {

            if (preorder[i] == Integer.MIN_VALUE) {
                continue;
            }
            int val = preorder[i];
            node = new TreeNode(val);
            preorder[i] = Integer.MIN_VALUE;
            int split = 0;
            for (; split < inorder.length; split++) {
                if (inorder[split] == val) {
                    inorder[split] = Integer.MIN_VALUE;
                    break;
                }
            }

            if (split == 0) {
                node.left = null;
            }
            if (split == inorder.length - 1) {
                node.right = null;
            }

            if (split > 0) {
                int[] leftorder = new int[split];
                for (int i1 = 0; i1 < split; i1++) {
                    leftorder[i1] = inorder[i1];
                }
                node.left = buildTree(preorder, leftorder);
            }

            if (split < inorder.length - 1) {
                int[] rightorder = new int[inorder.length - split - 1];
                for (int i2 = split + 1, j = 0; i2 < inorder.length; i2++, j++) {
                    rightorder[j] = inorder[i2];
                }
                node.right = buildTree(preorder, rightorder);
            }

            return node;
        }

        return node;
    }


}
