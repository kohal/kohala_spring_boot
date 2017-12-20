package com.reflex.service;

/**
 * @author: xuyongjian
 * @date: 2017/10/23
 */
public class StringFormat {
    public static void main(String[] args) {
        String orders = "511051041039\n" +
                "519010219330\n" +
                "510749133221\n" +
                "519112430794\n" +
                "519461013656";

        String[] orderArr = orders.split("\n");

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < orderArr.length; i++) {
            output.append("'" + orderArr[i].replaceAll(" +","") + "',");

        }

//        String cardNo = "55550184579861620006723415";
//        System.out.println(cardNo.length());
//        System.out.println(cardNo.substring(cardNo.length()-10,cardNo.length()));

        System.out.println(output.toString());

    }

}
