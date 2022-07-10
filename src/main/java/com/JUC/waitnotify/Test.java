package com.JUC.waitnotify;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/13 12:08
 */
public class Test {

    public static void main(String[] args) {
        final myTest myTest = new myTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest.add();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest.add();
                }
            }
        }).start();



        new  Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest.sub();
                }
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    myTest.sub();
                }
            }
        }).start();

    }

}
