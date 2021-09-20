package leetcode.simple;

import java.util.Arrays;

/**
 * 给定一个已按照 升序排列? 的整数数组?numbers ，请你从数组中找出两个数满足相加之和等于目标数?target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum167 {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::print);
        Arrays.stream(twoSum(new int[]{2, 3, 4}, 6)).forEach(System.out::print);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int left = 0;
        int right = numbers.length - 1;
        int[] ans = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }

}
