package leetcode.medium;

/**
 * ����һ���ַ��� s �������ҳ����в������ظ��ַ���?��Ӵ�?�ĳ��ȡ�
 * <p>
 * ?
 * <p>
 * ʾ��?1:
 * <p>
 * ����: s = "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 * <p>
 * ����: s = "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
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
