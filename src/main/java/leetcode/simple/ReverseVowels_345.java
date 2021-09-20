package leetcode.simple;

import java.util.Arrays;
import java.util.List;

/**
 * ����һ���ַ��� s ������ת�ַ����е�����Ԫ����ĸ�������ؽ���ַ�����
 * <p>
 * Ԫ����ĸ���� 'a'��'e'��'i'��'o'��'u'���ҿ����Դ�Сд������ʽ���֡�
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
