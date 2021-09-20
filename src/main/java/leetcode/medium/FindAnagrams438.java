package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串?s?和 p，找到?s?中所有?p?的?异位词?的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指字母相同，但排列不同的字符串。
 * <p>
 * ?
 * <p>
 * 示例?1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class FindAnagrams438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("baa", "aa"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, Integer> need = new HashMap<>();
        for (Character ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        int[] window = new int[26];
        while (right < s.length()) {
            char ch = s.charAt(right++);

            if (need.containsKey(ch)) {
                window[ch - 'a']++;
                if (window[ch - 'a'] == need.get(ch)) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }

                char c = s.charAt(left++);
                if (need.containsKey(c)) {
                    if (window[c - 'a'] == need.get(c)) {
                        valid--;
                    }
                    window[c - 'a']--;
                }
            }
        }

        return result;
    }
}
