package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���������ַ���?s?�� p���ҵ�?s?������?p?��?��λ��?���Ӵ���������Щ�Ӵ�����ʼ�����������Ǵ������˳��
 * <p>
 * ��λ�� ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * <p>
 * ?
 * <p>
 * ʾ��?1:
 * <p>
 * ����: s = "cbaebabacd", p = "abc"
 * ���: [0,6]
 * ����:
 * ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����λ�ʡ�
 * ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����λ�ʡ�
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
