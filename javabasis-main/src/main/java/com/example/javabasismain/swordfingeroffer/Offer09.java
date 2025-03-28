package com.example.javabasismain.swordfingeroffer;


import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"] [[],[3],[],[],[]]
 * <p>
 * 输出：[null,null,3,-1,-1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"] [[],[],[5],[2],[],[]]
 * <p>
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer09 {

    public static void main(String[] args) {

    }


    class CQueue {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            //如果第二个队列里面有数据直接往外弹
            while (stack2.size() > 0) {
                return stack2.pop();
            }
            if (stack1.size() > 0) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                return deleteHead();
            }
            return -1;
        }
    }


}
