package com.example.javabasismain.swordfingeroffer;


import com.example.javabasismain.swordfingeroffer.util.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * <p>
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Offer52 {
    public static void main(String[] args) {

    }


    /**
     * 这里需要注意 两个链表比较的时候是比较相同的节点，而不是比较val相同的值的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int headALength = 0, headBLength = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            headALength++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            headBLength++;
            tempB = tempB.next;
        }
        int superLength = headBLength > headALength ? headBLength - headALength : headALength - headBLength;
        boolean superBoolean = headBLength > headALength;

        while (superBoolean && superLength > 0) {
            headB = headB.next;
            superLength--;
        }
        while (!superBoolean && superLength > 0) {
            headA = headA.next;
            superLength--;
        }


        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

}
