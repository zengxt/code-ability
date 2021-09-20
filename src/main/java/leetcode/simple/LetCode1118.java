package leetcode.simple;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，
 * 计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
 */
public class LetCode1118 {
    public static void main(String[] args) {
        Arrays.stream(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 76})).forEach(System.out::print);
    }

    public static int[] dailyTemperatures(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }

        return res;
    }
}
