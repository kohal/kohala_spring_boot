package com.reflex.service.lisp;

import java.util.*;

/**
 * 评测题目:
 * /* 输入两个字符串，源字符串source和一个目标字符串target，
 * 输出source中包含target(无重复字符)所有字符的的第一个最小子串， 如果不存在，输出空字符串。
 * 说明：样例 source = "AUZDHNGAHSIWABDNC"，target = "AND" 满足要求的解 "ABDN"
 * <p>
 * <p>
 * 优化：1，可以用索引left，right代替新构建的数组； 2，用hash代替每次遍历target的问题
 *
 * @author: xuyongjian
 * @date: 2018/9/1
 */
public class LestFindString {

    public static void main(String[] args) {
        System.out.println(findLeast("AUZDHNGAHSIWABDNC", "AND"));


    }

    private static String findLeast(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int left = 0, right = 0, count = 0, minLen = tArr.length + 1;
        String res = "";

        Map<Character, Integer> mapT = hashArray(tArr);

        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];


            Integer clt = mapT.get(c);
            if (clt == null) {
                clt = -1;
            }
            if (clt == 1) {

                mapT.put(c, --clt);
            }

            if (clt >= 0) {
                count++;
            }
            while (count == tArr.length) {
                right = i;
                if (right - left <= minLen) {
                    minLen = right - left + 1;
                    res=String.valueOf(Arrays.copyOfRange(sArr, left , left  + minLen));
                }

                char c1 = sArr[left];

                Integer leftVal = mapT.get(c1);

                if ( leftVal!= null) {
                    mapT.replace(c1, ++leftVal);
                    if (leftVal > 0) {
                        count--;
                    }
                }
                left++;

            }




        }

        return res;


    }


    private static Map<Character, Integer> hashArray(char[] chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, 1);
        }
        return map;
    }



    private static String findShort(String sou, String tar) {

        char[] tarChars = tar.toCharArray();


        char[] souChars = sou.toCharArray();

        char[] out = new char[sou.length()];


        ArrayList<Character> outChars = new ArrayList<>();

        List<Character> lastChars = new ArrayList<>();

        boolean addOut = false;
        int outPat = 0;


        char[] tarC = Arrays.copyOf(tarChars, tarChars.length);


        for (char a : souChars) {
            int dAddr = contain(a, tarChars);
            int addr = contain(a, tarC);

            if (dAddr != -1) {

                if (addr != -1) {
                    addOut = true;
                    tarC[addr] = '1';

                } else {
                    outChars = new ArrayList<>();
                }

            }

            if (addOut) {
                out[outPat] = a;
                outChars.add(a);
                outPat++;
            }
            if (charsIsEmpty(tarC)) {

                if (lastChars.size() == 0) {
                    lastChars = copyList(outChars);
                }
//                lastChars = copyList(outChars);
                if (outChars.size() < lastChars.size()) {
                    lastChars = outChars;

                }

                outPat = 0;
                addOut = false;
                outChars = new ArrayList<>();

                tarC = Arrays.copyOf(tarChars, tarChars.length);


            }


        }

        return lastChars.toString();
    }

    private static int contain(char a, char[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == a) {
                return i;
            }
        }

        return -1;


    }


    private static boolean charsIsEmpty(char[] chars) {
        for (char c : chars) {
            if (c != '1') {
                return false;
            }
        }
        return true;
    }


    private static List<Character> copyList(List<Character> list) {

        return new ArrayList<>(list);
    }

}
