package org.un.mapz;

import java.util.StringTokenizer;

public class StringTokenizerEx {

    public void useStringTokenizer(String str) {
        // " ", "\t", "\n" 다 나눠줌 ( default )
        StringTokenizer stk = new StringTokenizer(str);
        System.out.println("str = " + str);
        System.out.println();

        System.out.println("total tokens : " + stk.countTokens());
        System.out.println("-----------tokens-----------");
        while (stk.hasMoreTokens()) {
            System.out.println(stk.nextToken());
        }
        System.out.println("total tokens : " + stk.countTokens());
    }

    public void useStringTokenizer(String str, String delims) {

        StringTokenizer stk = new StringTokenizer(str, delims);
        System.out.println("str = " + str);
        System.out.println();

        System.out.println("total tokens : " + stk.countTokens());
        System.out.println("-----------tokens-----------");
        while (stk.hasMoreTokens()) {
            System.out.println(stk.nextToken());
        }
        System.out.println("total tokens : " + stk.countTokens());
    }

    public void useStringTokenizer(String str, String delims, boolean flag) {
        // flag = true일 경우 delims의 각 문자열을 토큰에 포함
        StringTokenizer stk = new StringTokenizer(str, delims, flag);
        System.out.println("str = " + str);
        System.out.println();

        System.out.println("total tokens : " + stk.countTokens());
        System.out.println("-----------tokens-----------");
        while (stk.hasMoreTokens()) {
            System.out.println(stk.nextToken());
        }
        System.out.println("total tokens : " + stk.countTokens());
    }
    public void useSplit(String str) {
        // +split : String[]
        // regex를 기준으로 String을 나눠 배열로 반환
        System.out.println(str);
        System.out.println();

        System.out.println("----------user split method----------");
        String[] tokens = str.split(" ");

        for (String token : tokens) {
            System.out.println(token);
        }
    }
/*
*  split : 정확하게 delim으로 나눔
*  StringTokenizer : delim에 포함된 문자 하나하나 다 구분자로 씀
*
*/
    public static void main(String[] args) {
        String strEx1 = "this string includes default delims";
        String strEx2 = "this string\ticludes\ndefault delims";
        String strEx3 = "this-=string-includes=delims";
        StringTokenizerEx stex = new StringTokenizerEx();
//        stex.useSplit(strEx2);
//        stex.useStringTokenizer(strEx2); // " ", "\t", "\n" 다 나눠줌
//        stex.useStringTokenizer(strEx2, "-="); // -, =, -=로 분리함
//        stex.useStringTokenizer(strEx3, "-=", true);
    }
}
