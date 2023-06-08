package com.example.javabasismain.swordfingeroffer.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

public class MinStack {

    int[] result = null;

    int index;

    public MinStack() {
        index = 0;
        result = new int[20000];
        Arrays.fill(result, Integer.MAX_VALUE);
    }

    public void push(int x) {
        result[index] = x;
        index++;
    }

    public void pop() {
        result[index - 1] = Integer.MAX_VALUE;
        index--;
    }

    public int top() {
        return result[index - 1];
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            if (min > result[i]) {
                min = result[i];
            }
        }
        return min;
    }

}
