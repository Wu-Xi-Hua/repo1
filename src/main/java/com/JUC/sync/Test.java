package com.JUC.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/13 16:11
 *
 */
public class Test {

    private volatile  int a=0; 

    public static void main(String[] args) {
        final Test test = new Test();
        new Thread(()->{
            test.add();
        },"A1").start();
        new Thread(()->{
            test.add();
        },"A2").start();
    }


    private  int i = 0;

    public  void   add(){
          int a = 0;
           while(true){
               System.out.println(Thread.currentThread().getName()+"-----------------"+i+++"------"+a++);

//               try { TimeUnit.MICROSECONDS.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
               if(i==30){
                   break;
               }
           }


    }


}
