package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 华为OD机试 - 篮球游戏（Java & JS & Python & C & C++）
 */

public class C200iii34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputs = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] outputs = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int input : inputs) {
            queue.addLast(input);
            while (queue.size() > 0) {
                int left = queue.getFirst();
                int right = queue.getLast();
                if (left == outputs[index]) {
                    sb.append("L");
                    queue.removeFirst();
                    index++;
                } else if (right == outputs[index]) {
                    sb.append("R");
                    queue.removeLast();
                    index++;
                } else {
                    break;
                }
            }
        }

        if (queue.size() != 0) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
