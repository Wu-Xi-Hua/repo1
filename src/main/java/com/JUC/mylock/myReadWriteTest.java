package com.JUC.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/6/24 15:07
 */
public class myReadWriteTest {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    public void read(){
        readLock.lock();
        System.out.println("读取的内容："+Thread.currentThread().getName());
//        readLock.unlock();
    }

    public static void main(String[] args) {
        myReadWriteTest myReadWriteTest = new myReadWriteTest();
        new Thread(()->{
            myReadWriteTest.read();
        },"A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            myReadWriteTest.read();
        },"B").start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(()->{
//            myReadWriteTest.read();
//        },"C").start();

    }

}
