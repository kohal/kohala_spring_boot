package com.reflex.service;

/**
 * @author: xuyongjian
 * @date: 2018/4/10
 */
public class LongGeTest {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();


        String str = "eeefgghhh";
        System.out.println(print(str));
        long end = System.currentTimeMillis();
        System.out.println("ms:" + (end - start));
    }

    public static String print(String str) {
        StringBuilder sb = new StringBuilder();
        int[] array = new int[256];
        for (int i = 0; i < 256; i++) {
            array[i] = 0;
        }
        int maxValue = 0;
        for (int i = 0; i < str.length(); i++) {
            int b= str.charAt(i);
            array[b]++;
            if (array[b] > maxValue) {
                maxValue = array[b];
            }
        }

        for (int i = 0; i < maxValue; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0) {
                    sb.append((char) j);
                    array[j]--;
                }
            }
        }
        return sb.toString();
    }
}
