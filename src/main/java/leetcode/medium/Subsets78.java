package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组?nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        bfs(0, nums, result, temp);

        return result;
    }

    private static void bfs(int index, int[] nums, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            bfs(i + 1, nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static void bfs2(int index, int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // 不选择 index 号元素
        bfs2(index + 1, nums, result, temp);

        // 选择 index 号元素
        temp.add(nums[index]);
        bfs2(index + 1, nums, result, temp);
        temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        bfsWithDup(0, nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private static void bfsWithDup(int index, int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        result.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            temp.add(nums[i]);
            used[i] = true;
            bfsWithDup(i + 1, nums, result, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    private static void bfsWithDup2(int index, int[] nums, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            bfsWithDup2(i + 1, nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}