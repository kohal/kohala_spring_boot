package com.reflex;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/7/3
 */
public class HashCodeGet {

    public static void main(String[] args) {
//        String key = "a";
//        int h;
//        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));
//        System.out.println(key.hashCode());
//        System.out.println((h = key.hashCode()) & 15 );
//        System.out.println(Integer.toBinaryString(93) +"    "+Integer.toBinaryString(15));
//
//        HashMap map = Maps.newHashMap();
//        map.put("1","Hello World");
//        int a;
//        int b = a = 5;
//
//        System.out.println(a+"  "+b);
//
//
//        for (int i = 0; i < 4; i++) {
//            new Thread(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println(this.hashCode());
//                        }
//                    }
//            ).start();
////        }
//        Long d = 0L, c = 0L;
//        d = System.currentTimeMillis();
//
//        Integer[][] a = new Integer[2][100000];
//        c = System.currentTimeMillis();
//        System.out.println(c - d);
//    Integer[][] b = new Integer[2][100000];
//    Long b =0L , c =0L;
//    b = System.currentTimeMillis();
//    for(int i = 0 ; i <10000;i++){
//        for(int j = 0 ; j < 10000; j++){
//            a[i][j] = i+j;
//        }
//    }
//    c=System.currentTimeMillis();
//        System.out.println(c-b);
//    for(int i = 0 ; i <10000;i++){
//        for(int j = 0 ; j < 10000; j++){
//            a[j][i] = i+j;
//        }
//    }
//    b = System.currentTimeMillis();
//        System.out.println(b-c);
//
//    A a = new A();
//    a.x = 0;
    Integer b = new Integer(2);
    b=3;
    ss(b);
    System.out.println(b);

    }

    public static void ss(Integer a){
        System.out.println(a);
        a=2;
        Integer b=a+6;
        System.out.println(b);

    }

}
