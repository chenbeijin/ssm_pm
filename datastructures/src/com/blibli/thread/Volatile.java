package com.blibli.thread;

import java.util.concurrent.TimeUnit;

/**
 * volatile(关键字)        1. 可见性  2. 不保证原子性  3. 禁止指令重排
 * JMM(java内存模型)       1. 可见性  2. 保证原子性  3. 有序性
 */
class MyData {
    /**
     * volatile 多个线程可见 (可见性)
     */
    volatile int number = 0;

    public void addTo60() {
        number = 60;
    }

    //

    /**
     * 不保证原子性 在(频繁的调用有其他线程正要提交
     * ，而被抢先一步，就挂起等待，因为时间太短未能更新就提交了数据，所有导致有少部分丢失)
     */
    public void addPlusPlus() {
        number++;
    }
}

public class Volatile {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();     // 让步
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
    }

    /**
     * volatile 关键字可以保证可见性 及时通知其他线程
     */
    public static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value: " + myData.number);
    }
}
