package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        bfs(0, n, k, result, temp);

        return result;
    }

    private static void bfs(int index, int n, int k, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() + (n - index) < k) {
            return;
        }

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            temp.add(i + 1);
            bfs(i + 1, n, k, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
