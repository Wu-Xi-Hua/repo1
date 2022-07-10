package com.JUC.waitnotify;


/**
 * @Description:
 * @Author: 吴喜华
 * @Date: 2022/4/13
 *
 * 在超高高并发下如下代码会处于挂起状态
 * add--1------------1
 * add--1挂起
 * add--2挂起
 * sub--1------------0
 * add--1------------1
 * add--1挂起
 * add--2挂起
 * sub--1------------0
 * sub--1挂起
 * add--1------------1
 * add--1挂起
 * add--2挂起
 * sub--2------------0
 * sub--2挂起
 * sub--1挂起
 * 出现原因是被唤醒的线程又马上进入挂起状态，没有唤醒其他线程
 * 此时notifyall()方法出现的原因，可以解决该问题
 *
 *
 **/


/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/13 12:05
 */
public class myTest2 {
    public static void main(String[] args) {
       final myTest2 myTest2 = new myTest2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest2.add();

                }
            }
        },"add--1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest2.add();
                }
            }
        },"add--2").start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest2.sub();
                }
            }
        },"sub--1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest2.sub();
                }
            }
        },"sub--2").start();


    }

    private  int count=0;

    private synchronized void add(){

          while(count!=0){
              try {
                  System.out.println(Thread.currentThread().getName()+"挂起");
                  wait();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          count++;
          System.out.println(Thread.currentThread().getName()+"------------"+count);
//          notifyAll();
          notifyAll();

    }
    private synchronized void sub(){
//        notify();
        while(count==0){
            try {
                System.out.println(Thread.currentThread().getName()+"挂起");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"------------"+count);
//      notifyAll();
        notifyAll();

    }


}
