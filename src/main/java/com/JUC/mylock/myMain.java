package com.JUC.mylock;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/6/23 10:12
 */
public class myMain {
    public static void main(String[] args) {
        A a = new A();
        for (int i = 1;i<=2;i++){
            new Thread(()->{
                a.add();
            },"生产线程-----"+i).start();
        }
        for (int i = 1;i<=2;i++){
            new Thread(()->{
                a.jian();
            },"消费线程-----"+i).start();
        }
        System.out.println("主线程结束了");
    }

}

