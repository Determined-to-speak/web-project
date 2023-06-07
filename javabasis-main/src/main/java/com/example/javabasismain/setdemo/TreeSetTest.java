package com.example.javabasismain.setdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.TreeSet;

/**
 * @author lizhijiangjiang
 * @version 1.0
 * @description: TreeSet会自动对元素进行排序
 * @date 2023/2/13 9:35
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Integer> ts = new TreeSet<Integer>();
        //添加元素
        ts.add(10);
        ts.add(40);

        TreeSet<Integer> ts2 = new TreeSet<>(ts);
        TestPointer testPointer = new TestPointer();
        testPointer.ts = ts;
        testPointer.setTs2(ts2);
        System.out.println(testPointer.ts);
        System.out.println(testPointer.ts2);

        ts.add(30);
        ts.add(50);
        ts.add(20);
        ts.add(30);//执行结果是不包含重复元素
        System.out.println(testPointer.ts);
        System.out.println(testPointer.ts2);
        //遍历集合
        for (Integer s : ts) {
            System.out.println("元素为:" + s);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class TestPointer {
        TreeSet<Integer> ts;

        TreeSet<Integer> ts2;
    }
}
