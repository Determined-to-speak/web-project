package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.ListNode;
import com.example.javabasismain.swordfingeroffer.util.ListNodeUtil;

import java.util.Arrays;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer22 {
    public static void main(String[] args) {
        int[] head1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ListNodeUtil.parseListNodeToArray(getKthFromEnd(ListNodeUtil.paseArrayToListNode(head1), 2))));

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode[] temp = new ListNode[k];

        int i = 0;
        if (head == null) return null;

        ListNode cur = head;
        temp[0] = cur;

        while (cur.next != null) {
            i++;
            if (i < k) {
                temp[i] = cur.next;
            } else {
                for (int j = 0; j < temp.length && j + 1 < temp.length; j++) {
                    temp[j] = temp[j + 1];
                }
                temp[k - 1] = cur.next;
            }
            cur = cur.next;
        }

        return temp[0];

    }
}
