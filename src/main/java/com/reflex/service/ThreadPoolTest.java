package com.reflex.service;

/**
 * @Author: xuyongjian
 * @Date: 2017/8/27
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

            try {
                String s = null;
                System.out.println(s.trim());
            } catch (Exception e) {
//                e.printStackTrace();
                    throw e;
            } finally {

            }
        });
        thread.setUncaughtExceptionHandler((Thread t, Throwable e)->{
            System.out.println(e+"-----npe");
        });
        thread.start();

        System.out.println("tread end");
    }
}
