package com.Test;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/14 9:43
 */
public class StringTest2 {

    private  String abc="abc";
    private  String copyabc = "a"+"b"+"c";
    private  String a = "a";
    private  String b = "b";
    private  String c = "c";
    private  String abc1 = a+b+c;
    private  String abc12 = abc1.intern();


    public static void main(String[] args) {

        StringTest2 stringTest = new StringTest2();
        System.out.println(stringTest.abc == stringTest.abc1);//false
        System.out.println(stringTest.abc == stringTest.copyabc);// true
        System.out.println(stringTest.abc1 == stringTest.abc12);//false
        System.out.println(stringTest.abc == stringTest.abc12);//true
    }


}
