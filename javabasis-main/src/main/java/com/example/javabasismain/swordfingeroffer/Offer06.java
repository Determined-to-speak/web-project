package com.example.javabasismain.swordfingeroffer;

import com.example.javabasismain.swordfingeroffer.util.ListNode;
import com.example.javabasismain.swordfingeroffer.util.ListNodeUtil;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer06 {
    public static void main(String[] args) {
        ListNode param = ListNodeUtil.paseArrayToListNode(new int[]{1, 3, 2});
        System.out.println(Arrays.toString(reversePrint(param)));
    }


    /**
     * 使用递归
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        node = head;
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = node.val;
            node = node.next;
        }
        return result;
    }

    /**
     * 这种是使用栈的，不要用
     * @param head
     * @return
     */
//    public static int[] reversePrint(ListNode head) {
//        Stack<Integer> temp = new Stack<>();
//        while (head != null) {
//            temp.push(head.val);
//            head = head.next;
//        }
//        int[] result = new int[temp.size()];
//        for (int i = 0; temp.size() > 0; i++) {
//            result[i] = temp.pop();
//        }
//        return result;
//    }

}
