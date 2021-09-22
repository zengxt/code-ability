package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ����һ���ַ��� s�����㽫 s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����� ���Ĵ� ������ s ���п��ܵķָ����
 * ���Ĵ� �����Ŷ��ͷ��Ŷ���һ�����ַ�����
 * <p>
 * ʾ�� 1��
 * ���룺s = "aab"
 * �����[["a","a","b"],["aa","b"]]
 * <p>
 * ʾ�� 2��
 * ���룺s = "a"
 * �����[["a"]]
 */
public class Partition131 {
    public static void main(String[] args) {
        System.out.println(new Partition131().partition("aab"));
        System.out.println(new Partition131().partition("a"));
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return Collections.emptyList();

        // dp[i][j] ��ʾ �Ӵ� s[i-j] �Ƿ��ǻ����Ӵ�
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

        // ���� 0-index ֮����Ӵ��Ѿ��ָ���
        for (int i = index; i < str.length(); i++) {
            if (dp[index][i]) {
                temp.add(str.substring(index, i + 1));
                splitString(str, i + 1, dp, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
