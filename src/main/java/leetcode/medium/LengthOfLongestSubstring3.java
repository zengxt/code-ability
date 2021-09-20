package leetcode.medium;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的?最长子串?的长度。
 * <p>
 * ?
 * <p>
 * 示例?1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 */
public class LengthOfLongestSubstring3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("sjyzaeahyh"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }


    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int maxLengthOfSubString = 0;
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        while (right < str.length()) {
            char ch = str.charAt(right++);
            window[ch]++;

            while (window[ch] > 1) {
                window[str.charAt(left++)]--;
            }

            maxLengthOfSubString = Math.max(maxLengthOfSubString, right - left);
        }

        return maxLengthOfSubString;
    }
}
