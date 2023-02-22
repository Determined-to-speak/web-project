package setdemo;

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
        ts.add(30);
        ts.add(50);
        ts.add(20);
        ts.add(30);//执行结果是不包含重复元素
        //遍历集合
        for (Integer s : ts) {
            System.out.println("元素为:" + s);
        }
    }
}
