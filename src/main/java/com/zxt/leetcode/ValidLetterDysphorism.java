package com.zxt.leetcode;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class ValidLetterDysphorism {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));  // true
        System.out.println(isAnagram("rat", "car")); // false
        System.out.println(isAnagram("a", "b")); // false
        System.out.println(isAnagram("dgqztusjuu", "dqugjzutsu")); // true
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        StringBuilder target = new StringBuilder(t);
        for (char c : s.toCharArray()) {
            int index = target.indexOf(String.valueOf(c));
            if (index == -1) {
                return false;
            }
            target.deleteCharAt(index);
        }

        return target.length() == 0;
    }
}
