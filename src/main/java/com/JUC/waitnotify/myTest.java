package com.JUC.waitnotify;


/***
 * @Description:
 * @Author: 吴喜华
 * @Date: 2022/4/13
 * wait()没有获取锁时调用会报  java.lang.IllegalMonitorStateException 异常
 *
 *
 **/

import java.util.concurrent.TimeUnit;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/13 9:42
 */
public class myTest {

    private  int count=0;

    public synchronized void add(){

          if (count==0){
              count++;
              System.out.println(count);
          }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();

    }
    public synchronized void sub(){

        if (count!=0){
            count--;
            System.out.println(count);
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }


}
