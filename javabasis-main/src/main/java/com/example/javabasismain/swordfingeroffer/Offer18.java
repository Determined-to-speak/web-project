package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.ListNode;
import com.example.javabasismain.swordfingeroffer.util.ListNodeUtil;

import java.util.Arrays;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Offer18 {
    public static void main(String[] args) {

        int[] head1 = new int[]{4, 5, 1, 9};
        System.out.println(Arrays.toString(ListNodeUtil.parseListNodeToArray(deleteNode(ListNodeUtil.paseArrayToListNode(head1), 5))));

        int[] head2 = new int[]{4, 5, 1, 9};
        System.out.println(Arrays.toString(ListNodeUtil.parseListNodeToArray(deleteNode(ListNodeUtil.paseArrayToListNode(head2), 1))));

        int[] head3 = new int[]{-3, 5, -99};
        System.out.println(Arrays.toString(ListNodeUtil.parseListNodeToArray(deleteNode(ListNodeUtil.paseArrayToListNode(head3), -99))));


    }


    /**
     * 删除节点，可以将下一个节点直接覆盖当前的节点，这样就不用遍历到需要删除节点的前一个节点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {

        if (head == null) return null;
        if (head.next == null && head.val == val) {
            return null;
        }
        if (head.val == val) return head.next;


        //这里一定要特别注意node使用的具体节点
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
            pre.next = cur.next;
        }
        return head;

    }


}
