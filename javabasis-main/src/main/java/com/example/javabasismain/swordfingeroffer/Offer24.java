package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.ListNode;
import com.example.javabasismain.swordfingeroffer.util.ListNodeUtil;

import java.util.Arrays;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 */
public class Offer24 {

    public static void main(String[] args) {

        int[] param1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ListNodeUtil.parseListNodeToArray(reverseList(ListNodeUtil.paseArrayToListNode(param1)))));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = head;
        ListNode mynext = pre.next;

        pre.next = null;
        while (mynext != null) {
            ListNode temp = pre;
            pre = mynext;
            mynext = mynext.next;
            pre.next = temp;
        }
        return pre;
    }
}
