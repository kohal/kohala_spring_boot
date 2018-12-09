package com.reflex.service.lisp;

/**
 * Created by xuyongjian on 2016/12/26.
 */
public class TestString {

    private static void changeStr(String input){
        input =new String("world");
    }

    public static void main(String[] args) {
        String str="hello";
        changeStr(str);
        System.out.println(str);
    }
}
