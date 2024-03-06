package com.example.javabasismain.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C200iii24 {

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Range> priorityQueue = new PriorityQueue<>((a, b) -> a.end != b.end ? b.end - a.end : b.start - a.start);
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new Range(sc.nextInt(), sc.nextInt()));
        }

        int count = 0;
        //上一个任务的执行时刻
        int last_end = Integer.MAX_VALUE;
        while (priorityQueue.size() > 0) {
            Range range = priorityQueue.poll();

            if (range.end < last_end) {
                last_end = range.end;
                count++;
            } else if (last_end > range.start) {
                range.end = last_end - 1;
                priorityQueue.offer(range);
            }
        }
        System.out.println(count);
    }
}
