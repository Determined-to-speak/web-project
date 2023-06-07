package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.ListNode;
import com.example.javabasismain.swordfingeroffer.util.ListNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * <p>
 * 输出：1->1->2->3->4->4
 * <p>
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class Offer25 {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4};
        System.out.println(Arrays.toString(ListNodeUtil.parseListNodeToArray(mergeTwoLists(ListNodeUtil.paseArrayToListNode(l1), ListNodeUtil.paseArrayToListNode(l2)))));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = null;
        if (l1.val < l2.val) {
            result = l1;
            System.out.println("变之前：" + result.val + " " + l1.val);
            l1 = l1.next;
            System.out.println("变之后：" + result.val + " " + l1.val);
            result.next = mergeTwoLists(l1, l2);
        } else {
            result = l2;
            l2 = l2.next;
            result.next = mergeTwoLists(l1, l2);
        }
        return result;
    }
}
