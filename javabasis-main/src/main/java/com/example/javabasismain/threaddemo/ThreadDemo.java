package com.example.javabasismain.threaddemo;

/**
 * 基本ThreadDemo
 */
public class ThreadDemo {

    public static void main(String[] args) {

        //region 测试interrupt方法
        System.out.println("begin");
        Thread awaitThread = new Thread(() -> {
            System.out.println("begin current awaitThread ! ");
            try {
                Thread.sleep(10000);
                System.out.println("after sleep !");
            } catch (InterruptedException e) {
                //注意这里，如果外面中断了这里的线程，会跳到这个异常里
                System.out.println("interrupt current awaitThread ! ");
            }
        });
        awaitThread.start();
        awaitThread.interrupt(); //如果将这里注释掉，会阻塞sleep中的数字时间
        System.out.println("finish");
        //endregion

    }
}
