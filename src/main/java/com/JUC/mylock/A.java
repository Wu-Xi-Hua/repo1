package com.JUC.mylock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/6/23 10:11
 */
public class A {
    private Lock lock = new ReentrantLock();
    private Condition conditionadd = lock.newCondition();
    private Condition conditionjian = lock.newCondition();
    private  int  i=0;
    public void add(){
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            while(i!=0){
                conditionadd.await();
            }
            i++;
            System.out.println(Thread.currentThread().getName()+"----当前数量："+i);
            conditionjian.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
    public void jian(){
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            while(i==0){
                conditionjian.await();
            }
            i--;
            System.out.println(Thread.currentThread().getName()+"----当前数量："+i);
            conditionadd.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
