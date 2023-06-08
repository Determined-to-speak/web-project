package com.example.javabasismain.swordfingeroffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer31 {
    public static void main(String[] args) {
        int[] pushed1 = new int[]{1, 2, 3, 4, 5};
        int[] popped1 = new int[]{4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed1, popped1));

        int[] pushed2 = new int[]{1, 2, 3, 4, 5};
        int[] popped2 = new int[]{4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushed2, popped2));

        int[] pushed3 = new int[]{0, 2, 1};
        int[] popped3 = new int[]{0, 1, 2};
        System.out.println(validateStackSequences(pushed3, popped3));

    }

    /**
     * 辅助栈的思想
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; i++) {

            if (stack.size() != 0 && stack.peek() == popped[i]) {
                stack.pop();
                continue;
            }

            boolean flag = false;
            for (; j < pushed.length; ) {
                stack.push(pushed[j]);
                j++;
                if (stack.peek() == popped[i]) {
                    flag = true;
                    stack.pop();
                    break;
                }
            }

            if (flag) continue;
            return false;
        }

        return true;
    }

//    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
//        int lastPop = -1;
//        for (int j = 0; j < popped.length; j++) {
//            int popValue = popped[j];
//
//            if (j == 0) {
//                boolean flag_1 = false;
//                for (int i = 0; i < pushed.length; i++) {
//                    if (pushed[i] == popValue) {
//                        flag_1 = true;
//                        pushed[i] = -1;
//                        lastPop = i;
//                        break;
//                    }
//                }
//                if (!flag_1) {
//                    return false;
//                } else {
//                    continue;
//                }
//            }
//
//            int last = pushed.length - 1;
//            while (pushed[last] == -1) {
//                last--;
//            }
//            if (pushed[last] == popValue) {
//                pushed[last] = -1;
//                lastPop = last;
//                continue;
//            }
//
//
//            int leftIndex = lastPop - 1;
//            while (0 <= leftIndex && pushed[leftIndex] == -1) {
//                leftIndex--;
//            }
//            if (0 <= leftIndex && pushed[leftIndex] == popValue) {
//                pushed[leftIndex] = -1;
//                lastPop = leftIndex;
//                continue;
//            }
//
//            int rightIndex = lastPop + 1;
//            boolean flag = false;
//            while (rightIndex < pushed.length) {
//                if (pushed[rightIndex] == popValue) {
//                    pushed[rightIndex] = -1;
//                    lastPop = rightIndex;
//                    flag = true;
//                    continue;
//                }
//                rightIndex++;
//            }
//            if (flag) continue;
//
//            return false;
//
//        }
//        return true;
//    }
}
