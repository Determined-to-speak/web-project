package com.example.javabasismain.huawei;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 中缀表达式符号运算
 */
public class C200iii16 {

    static class Fractions {
        int fa; //分母
        int ch; //分子

        public Fractions() {

        }

        public Fractions(int fa, int ch) {
            this.fa = fa;
            this.ch = ch;
        }
    }

    //操作数栈
    static LinkedList<Fractions> oper_num = new LinkedList<>();
    static LinkedList<Character> oper_sign = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        StringBuilder numStr = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                while (c >= '0' && c <= '9') {
                    numStr.append(c);
                    if (i + 1 >= s.length()) break;
                    i++;
                    c = s.charAt(i);
                }
                oper_num.addLast(new Fractions(1, Integer.parseInt(numStr.toString())));
                //最后扫描完清除numStr变量;
                numStr = new StringBuilder();
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 只要栈顶运算符的优先级 >= 当前运算符，就需要不停出栈运算
                while (oper_sign.size() > 0 && oper_sign.getLast() != '(' && priority.get(c) <= priority.get(oper_sign.getLast())) {
                    cals();
                }
                oper_sign.addLast(c);
            } else if (c == ')') {
                while (oper_sign.getLast() != '(') {
                    cals();
                }
                oper_sign.removeLast();
            } else if (c == '(') {
                oper_sign.add(c);
            }
            i++;
        }

        //oper_num栈中还有两个以上的数，则还需要进行运算
        while (oper_num.size() > 1) {
            cals();
        }

        //只剩一个数，该数就是表达式的结果
        Fractions result = oper_num.removeLast();
        if (result.fa == 0) {
            System.out.println("ERROR");
        }

        //求分子分母的最大公约数，并进行约分，求得最简格式的分子分母
        int k = getMaxCommonDivisor(result.fa, result.ch);
        result.fa /= k;
        result.ch /= k;

        String sign = (result.fa > 0 && result.ch < 0) || (result.fa < 0 && result.ch > 0) ? "-" : "";

        int fa = Math.abs(result.fa);
        int ch = Math.abs(result.ch);

        if (fa == 1) {
            System.out.println(sign + ch);
        } else {
            System.out.println(sign + ch + "/" + fa);
        }
    }

    /**
     * 取出oper_num栈顶两个操作数进行运算
     */
    public static void cals() {
        Fractions b = oper_num.removeLast(); //栈顶元素是运算符右边的操作数
        Fractions a = oper_num.removeLast(); //栈顶倒数第二个元素是运算符左边的操作数

        //运算符
        char op = oper_sign.removeLast();

        Fractions result = new Fractions();

        switch (op) {
            case '+':
                result.fa = a.fa * b.fa;
                result.ch = a.ch * b.fa + b.ch * a.fa;
                break;
            case '-':
                result.fa = a.fa * b.fa;
                result.ch = a.ch * b.fa - b.ch * a.fa;
                break;
            case '*':
                result.fa = a.fa * b.fa;
                result.ch = a.ch * b.ch;
                break;
            case '/':
                result.fa = a.fa * b.ch;
                result.ch = a.ch * b.fa;
                break;
        }

        oper_num.add(result);
    }

    /**
     * 这里是基本的辗转相除法
     *
     * @param x 分母
     * @param y 分子
     * @return
     */
    private static int getMaxCommonDivisor(int x, int y) {
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }


}
