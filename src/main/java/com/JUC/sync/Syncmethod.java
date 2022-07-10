package com.JUC.sync;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/13 21:33
 */
public class Syncmethod {



    //    public static synchronized void method3(){
//        System.out.println("----------------");
//    }
//
//
//    public synchronized void  method1(){
//        System.out.println("-----");
//    }
    public void method2(){
        synchronized (this){
            System.out.println("--------------");
        }

    }
    public void method4(){
        synchronized (this){
            System.out.println("------------");
            throw new RuntimeException();
        }
    }


}
