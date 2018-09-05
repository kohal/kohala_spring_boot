package com.reflex.service;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。举例！假设原始字符串为：eeefgghhh，重新排序后的字符串如下：efghegheh（请注意大小写，并且只会出现数字和字母）
 *
 * @author: xuyongjian
 * @date: 2018/4/10
 */
public class StrSort {


    public static void main(String[] args) {

        String str = "eeefgghhh";
        System.out.println(sortStr(str));

    }

    private static String sortStr(String in) {

        long start = System.currentTimeMillis();
        StringBuilder out = new StringBuilder();
        char[] chars = in.toCharArray();
        TreeMap<Comparable, Integer> treeMap = Maps.newTreeMap();
        for (int i = 0; i < chars.length; i++) {
            treeMap.merge(chars[i], 1, (a, b) -> a + b);
        }

        System.out.println("ms:" + (System.currentTimeMillis() - start));

        while (!treeMap.isEmpty()) {
            Iterator<Map.Entry<Comparable, Integer>> iterator = treeMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Comparable, Integer> next = iterator.next();
                Integer count = next.getValue();
                if (count != 0) {
                    count--;
                    out.append(next.getKey().toString());
                    next.setValue(count);
                } else {
                    iterator.remove();
                }

            }
        }

        System.out.println("ms:" + (System.currentTimeMillis() - start));

        return out.toString();

    }


}
