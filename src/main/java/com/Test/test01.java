package com.Test;

import java.util.Scanner;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/17 23:06
 */
public class test01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("i----"+i);
        Stack stack = new Stack(i);
        for(int j=0 ; j < i ; j++){
            int a =0  ;
            String next = scanner.next();
            if(next.startsWith("push")){
                a = Integer.parseInt(next.substring(next.length() - 1));
                next = next.substring(0, next.length() - 2);
            }
            switch (next){
               case "push" :  stack.push(a); break;
               case "pop" :
                   System.out.println(stack.pop());
                   break;
               case "top" :
                   System.out.println(stack.top());
                   break;
            }

        }
    }


    static class  Stack{
        int [] stack;
        int index;

        public Stack(int size) {
            this.stack =  new int[size];
            this.index = 0;
        }

        public void push(int value){
              stack[index] = value;
              index++;
        }
        public int  pop(){
            if(index == 0){
//                throw  new RuntimeException("error: stack no value");
                System.out.println("error");
            }
            int returnValue = stack[--index];
            stack[index++] = 0;
            index--;
            return  returnValue;
        }
        public int  top(){
            if(index == 0){
//                throw  new RuntimeException("error: stack no value");
                  System.out.println("error");
                  return -1;
            }
            int showIndex = index -1;
            return  stack[showIndex];
        }

    }

}
