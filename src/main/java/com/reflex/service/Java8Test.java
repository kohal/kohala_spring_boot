package com.reflex.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Java8Test {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

//        System.out.println("输出大于 3 的所有数字:");
        eval(list, n -> n > 3);

//      Runnable
//        new Thread(
//                () -> {
//                    System.out.print("Hello");
//                    System.out.println("World");
//                }
//        ).start();

        List<String> strList = Arrays.asList("I", "love", "you", "too");
//       Comparator
        Collections.sort(strList, (s1, s2) ->s1.compareTo(s2) );// 省略参数表的类型
//            if (s1 == null)
//                return -1;
//            if (s2 == null)
//                return 1;
////            return s1.length() - s2.length();
//            return 1;
//        });
////        Consumer
//        strList.forEach((s) ->
//                System.out.println(s)
//        );
//
//        System.out.println(strList);
    }

//谈谈我对lambda表达式的理解，接口定义了函数的输入和输出的类型；
//以范畴学的说法， 定义了 函子的类型，接口的实现就是 这个函子的map接口传入的变形方法
// 一般约定，函子的标志就是容器具有map方法。该方法将容器里面的每一个值，映射到另一个容器。

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {

            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}