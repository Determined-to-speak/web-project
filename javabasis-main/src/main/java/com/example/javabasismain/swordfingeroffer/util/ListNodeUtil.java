package com.example.javabasismain.swordfingeroffer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 工具类
 */
public class ListNodeUtil {

    /**
     * 将 int_Array转化为ListNode
     *
     * @param param
     * @return
     */
    public static ListNode paseArrayToListNode(int[] param) {
        ListNode[] listNodes = new ListNode[param.length];
        for (int i = 0; i < param.length; i++) {
            ListNode listNode = new ListNode(param[i]);
            listNodes[i] = listNode;
        }


        for (int i = listNodes.length - 1; i >= 0; i--) {
            if (i == 0) {
                return listNodes[i];
            }
            listNodes[i - 1].next = listNodes[i];
        }
        return listNodes[0];
    }

    public static int[] parseListNodeToArray(ListNode param) {
        if (param == null) return null;
        List<Integer> resultList = new ArrayList<>();
        do {
            resultList.add(param.val);
            param = param.next;
        } while (param != null);

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
