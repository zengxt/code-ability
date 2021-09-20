package leetcode.simple;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����һ������T����������ŵ��ǽ�������������£��㷵��һ���ȳ������飬
 * ���㣺����ÿһ�죬�㻹Ҫ���ٵȶ�������ܵȵ�һ����ů�͵����£�����Ȳ�����һ�죬�� 0��
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
