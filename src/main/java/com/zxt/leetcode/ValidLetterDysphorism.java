package com.zxt.leetcode;

/**
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * ����: s = "anagram", t = "nagaram"
 * ���: true
 * <p>
 * ����: s = "rat", t = "car"
 * ���: false
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
