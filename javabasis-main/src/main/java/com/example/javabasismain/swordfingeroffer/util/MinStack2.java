package com.example.javabasismain.swordfingeroffer.util;

import java.util.Objects;
import java.util.Stack;

public class MinStack2 {

    Stack<Integer> A, B;

    public MinStack2() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        if (Objects.equals(A.pop(), B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
