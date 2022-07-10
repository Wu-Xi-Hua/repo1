package com.Test;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/14 9:43
 */
public class StringTest3 {


    private String a = new StringBuffer("计算机").append("黑马").toString();// 计算机黑马堆对象，计算机堆对象，黑马堆对象，计算机池对象，黑马池对象
    private String a1 = a.intern();        // 计算机黑马堆对象  没有复制到池中
    private String  ab = "计算机黑马";
    private  String ab1 = ab.intern();     //  计算机黑马池引用



    private String java = new StringBuffer("ja").append("va").toString();   //java 堆引用
    private String java1 = java.intern();   //java 堆引用
    private String java2 = "java";          //java 池引用


    public static void main(String[] args) {

        StringTest3 stringTest = new StringTest3();
        System.out.println(stringTest.a == stringTest.a1);  // true
        System.out.println(stringTest.ab == stringTest.a1); //true
        System.out.println(stringTest.ab == stringTest.ab1);//true
        System.out.println(stringTest.ab == stringTest.a1); //true

        System.out.println(stringTest.a == stringTest.ab);  //true
        System.out.println(stringTest.a == stringTest.ab1); //true
        System.out.println(stringTest.a1 == stringTest.ab);//true

//        System.out.println(stringTest.a1 == stringTest.ab); // false
//
//        System.out.println(stringTest.a1 == stringTest.ab1);// false


    }


}
