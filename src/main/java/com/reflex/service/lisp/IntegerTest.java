package com.reflex.service.lisp;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/6/15
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = null;
        Integer b=a==null? null: a.intValue();
        System.out.println(b);


        int c= 500;
        int d=500;
        System.out.println("_____"+(d/c+1));

    }
}
