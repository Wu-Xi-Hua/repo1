package com.Test;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/14 9:43
 */
public class StringTest {
    private final String a = "a";


    private String ab = "a"+"b";

    private String copyAB = a+"b";

    private String newAB = new String("ab");

    private String copyAB1 = a+getA();

    public  String getA(){
        return "a";
    }

    public static void main(String[] args) {

        StringTest stringTest = new StringTest();
        final String copyA = stringTest.getA();
        System.out.println(stringTest.a==copyA);//true   "a"   return "a";  都返回字符串常量池的引用

        System.out.println(stringTest.ab == stringTest.copyAB);//true        "a"+"b"    a+"b"

        System.out.println(stringTest.copyAB == stringTest.copyAB1);//false   a+"b"     a+getA();

        System.out.println(stringTest.ab == stringTest.copyAB1);//fasle       "a"+"b"     a+getA();

        System.out.println(stringTest.ab == stringTest.newAB);//false         "a"+"b"   new String("ab");

        System.out.println(stringTest.newAB == stringTest.copyAB);//false      a+"b"    new String("ab");

    }


}
