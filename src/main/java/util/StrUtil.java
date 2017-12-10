package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lynn on 2017/12/10.
 */
public class StrUtil {

    /**
     * 一个字符串的所有字符是否全都不同
     * @param str
     * @return
     */
    public static boolean isUniqueChars(String str) {
        // by arrlist
//        ArrayList<Character> arrayList = new ArrayList<Character>(str.length());
//        for (int i=0; i<str.length(); i++) {
//            Character character = str.charAt(i);
//            if (!arrayList.contains(character)) {
//                arrayList.add(character);
//            } else {
//                return false;
//            }
//        }
//        return true;

        // 时间复杂度 O(n^2) 空间复杂度 O(1)
//        for (int i=1; i<str.length(); i++) {
//            for (int j=0; j<i; j++) {
//                if (str.charAt(j) == str.charAt(i)) {
//                    return false;
//                }
//            }
//        }
//        return true;

        // 字符集ASCII 时间复杂度 O(n) 空间复杂度 O(1)
//        if (str.length() > 256) {
//            return false;
//        }
//        boolean[] charSet = new boolean[256];
//        for (int i=0; i<str.length(); i++) {
//            int val = str.charAt(i);
//            if (charSet[val]) {
//                return false;
//            }
//            charSet[val] = true;
//        }
//        return true;

        // 假设只含有a-z 用位运算减少空间占用
        if (str.length() > 26) {
            return false;
        }
        int checker = 0;
        for (int i=0; i<str.length(); i++) {
            int val = str.charAt(i) - 'a';
            int temp = 1 << val;
            if ((checker & temp) != 0) {
                return false;
            }
            checker = checker | temp;
        }
        return true;
    }

    /**
     * 翻转一个字符串
     * @param str
     */
    public static String reverse(String str) {
        String reverseStr = "";
        for (int i=str.length()-1; i>=0; i--) {
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }

    /**
     * 一个字符串重新排列后能否变成另一个字符串
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equalsIgnoreTurn(String s1, String s2) {
        // 排序后比较
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//        return chars1.toString().equals(chars2.toString());

        // 相同字符出现次数相同
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letterCount = new int[256];
        for (int i=0; i<s1.length(); i++) {
            letterCount[s1.charAt(i)]++;
        }
        for (int i=0; i<s2.length(); i++) {
            if (--letterCount[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static String encodeSpace(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

//    public static void replaceSpace(char[] str, int length) {
//        int spaceCount = 0;
//        int newLength, i;
//        for (i=0; i<length; i++) {
//            if (str[i] == ' ') {
//                spaceCount++;
//            }
//        }
//        newLength = length + spaceCount * 2;
//        str[newLength] = '\0';
//        for (i=length-1; i>=0; i--) {
//            if (str[i] == ' ') {
//                str[--newLength] = '0';
//                str[--newLength] = '2';
//                str[--newLength] = '%';
//            } else {
//                str[--newLength] = str[i];
//            }
//        }
//    }

    public static String compress(String str) {
        int length = str.length();
        char temp = str.charAt(0);
        int count = 1;
        String newStr = "";
        for (int i=1; i<length; i++) {
            if (str.charAt(i) == temp) {
                count ++;
            } else {
                newStr = newStr + temp + count;
                if (newStr.length() >= length) {
                    return str;
                }
                temp = str.charAt(i);
                count = 1;
            }
        }
        newStr = newStr + temp + count;
        if (newStr.length() >= length) {
            return str;
        }
        return newStr;
    }
}
