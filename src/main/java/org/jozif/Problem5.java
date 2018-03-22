package org.jozif;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Problem5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 长度最长为1000。
     * <p>
     * 示例:
     * <p>
     * 输入: "babad"
     * <p>
     * 输出: "bab"
     * <p>
     * 注意: "aba"也是有效答案
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: "cbbd"
     * <p>
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {
        int i = 0;
        int he = 0;
        int pointer = 0;
        String longestPalindrome = "";
        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length / 2 + 1; j++) {
            i = j;
            he = j;
            while (myLeftEquaHisRight(chars, i, he)) {
                i -= 1;
                he += 1;
            }
            String substring = s.substring(i, he);
            if (longestPalindrome.length() < substring.length()) {
                longestPalindrome = substring;
            }
        }
        return s.substring(i-1, he);
    }

    private boolean myLeftEquaHisRight(char[] chars, int i, int he) {
        if (i == he) {
            if (i == 0 && he !=0){
                return false;
            } else if (i == chars.length-1 && chars.length-1 !=0){
                return false;
            }
        }

        if (i > 0 && he < chars.length && chars[i - 1] == chars[he + 1] && chars[i + 1] == chars[he - 1]) {
            return true;
        } else {
            return false;
        }
    }
}