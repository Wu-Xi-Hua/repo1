package com.JUC.mylock;

/**
 * @author ��ϲ��
 * @version 1.0
 * @date 2022/6/23 10:12
 */
public class myMain {
    public static void main(String[] args) {
        A a = new A();
        for (int i = 1;i<=2;i++){
            new Thread(()->{
                a.add();
            },"�����߳�-----"+i).start();
        }
        for (int i = 1;i<=2;i++){
            new Thread(()->{
                a.jian();
            },"�����߳�-----"+i).start();
        }
        System.out.println("���߳̽�����");
    }

}

