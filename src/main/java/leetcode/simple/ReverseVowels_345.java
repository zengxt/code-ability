package leetcode.simple;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 */
public class ReverseVowels_345 {
    private static final List<Character> yuanYin = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        System.out.println(new ReverseVowels_345().reverseVowels("hello"));
        System.out.println(new ReverseVowels_345().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !isYuanYin(chars[left])) {
                left++;
            }

            while (left < right && !isYuanYin(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return String.valueOf(chars);
    }

    private boolean isYuanYin(char ch) {
        return yuanYin.stream().filter(character -> character == ch).findAny().isPresent();
    }
}
