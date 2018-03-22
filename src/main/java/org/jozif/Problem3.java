package org.jozif;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Problem3 {
    /**
     * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例：
     * <p>
     * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     * <p>
     * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
     * <p>
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
     */
    public int lengthOfLongestSubstring1(String s) {
        System.out.println("string: " + s);
        Map<Character, List<Integer>> map = new HashMap<>();
        int longestSubstringLen = 0;
        String substring = "";
        String longestSubstring = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = map.get(Character.valueOf(chars[i]));
            if (null != list) {
                list.add(i);
            } else {
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(Character.valueOf(chars[i]), list);
            }
        }

        if (map.size() == s.length()) {
            longestSubstringLen = s.length();
            substring = s;
            longestSubstring = substring;
        } else {
            for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                System.out.println(entry.getKey() + ":" + list.toString());
                if (list.size() == 1) {
                    int substringLen = 1;
                    if (substringLen > longestSubstringLen) {
                        longestSubstringLen = substringLen;
                        substring = s.substring(list.get(0), list.get(0) + 1);
                        longestSubstring = substring;
                    }
                }
                if (list.size() > 1) {
                    for (int k = 1, j = 0; k < list.size(); k++, j++) {
                        int substringLen = 0;
                        if (list.get(k) - list.get(j) == 1) {
                            if (map.size() > 1) {
                                substringLen = 2;
                                substring = s.substring(list.get(j), list.get(k));
                                substring += substring;
                            } else {
                                substringLen = 1;
                                substring = s.substring(list.get(j), list.get(k));
                            }
                        } else {
                            substringLen = list.get(k) - list.get(j);
                            substring = s.substring(list.get(j), list.get(k));
                        }
                        if (substringLen > longestSubstringLen) {
                            longestSubstringLen = substringLen;
                            longestSubstring = substring;

                        }
                    }
                }

            }

            if (longestSubstringLen == 0) {
                longestSubstringLen = s.length();
                longestSubstring = substring;
            }
        }

        System.out.println("longestSubstring: " + longestSubstring);
        return longestSubstringLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int longestSubstringLen = 0;
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < s.length() && flag; i++) {
            int substringLen = 0;
            for (int j = i + 1; j < s.length() - i; j++) {
                System.out.println("i: " + chars[i] + ", j: " + chars[j]);
                if (chars[i] == chars[j]) {
                    substringLen = j - i;
                }
            }
            if (substringLen > longestSubstringLen) {
                longestSubstringLen = substringLen;
            }
        }
        return longestSubstringLen;
    }

    //超时
    public int lengthOfLongestSubstring3(String s) {
        int longestSubstringLen = 0;
        for (int i = 0; i < s.length() && s.length() - i > longestSubstringLen && i < 100; i++) {

            for (int j = i + 1; j < (s.length() + 1) && j < 100; j++) {
                if ((j - i) > longestSubstringLen) {
                    String substring = s.substring(i, j);
//                    System.out.println(substring);
                    List<String> substringList = new ArrayList<>();
                    Set<String> substringSet = new HashSet<>();
                    for (char c : substring.toCharArray()) {
                        substringList.add(String.valueOf(c));
                        substringSet.add(String.valueOf(c));
                    }
                    if (substringList.size() == substringSet.size()) {
//                        System.out.println("!!!"+substring);
                        longestSubstringLen = substring.length();
                    } else {
                        break;
                    }
                }
            }
        }
        return longestSubstringLen;
    }


    public int lengthOfLongestSubstring(String s) {
        int longestSubstringLen = 0;
        for (int i = 0; i < s.length() && s.length() - i > longestSubstringLen && i < 100; i++) {
            for (int j = i + 1; j < (s.length() + 1) && j < 100; j++) {
                String substring = s.substring(i, j);
                //TODO substring改为chars试试
                Set<String> substringSet = new HashSet<>();
                for (char c : substring.toCharArray()) {
                    if (substringSet.contains(String.valueOf(c))) {
                        longestSubstringLen = Math.max(substringSet.size(), longestSubstringLen);
                        break;
                    } else {
                        substringSet.add(String.valueOf(c));
                    }
                }
                if (substringSet.size() == substring.length()) {
                    longestSubstringLen = Math.max(substringSet.size(), longestSubstringLen);
                }
            }
        }
        return longestSubstringLen;
    }
}