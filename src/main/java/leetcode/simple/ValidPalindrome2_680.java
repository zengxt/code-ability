package leetcode.simple;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class ValidPalindrome2_680 {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome2_680().validPalindrome("cbbcc"));
        System.out.println(new ValidPalindrome2_680().validPalindrome("aba"));
        System.out.println(new ValidPalindrome2_680().validPalindrome("abca"));
        System.out.println(new ValidPalindrome2_680().validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return isPalindrome(chars, left + 1, right)
                        || isPalindrome(chars, left, right - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
