package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class Partition131 {
    public static void main(String[] args) {
        System.out.println(new Partition131().partition("aab"));
        System.out.println(new Partition131().partition("a"));
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return Collections.emptyList();

        // dp[i][j] 表示 子串 s[i-j] 是否是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        splitString(s, 0, dp, result, temp);

        return result;
    }

    private void splitString(String str, int index, boolean[][] dp, List<List<String>> result, List<String> temp) {
        if (index == str.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // 假设 0-index 之间的子串已经分隔完
        for (int i = index; i < str.length(); i++) {
            if (dp[index][i]) {
                temp.add(str.substring(index, i + 1));
                splitString(str, i + 1, dp, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
