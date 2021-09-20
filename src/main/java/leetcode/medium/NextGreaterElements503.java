package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 */
public class NextGreaterElements503 {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElements(new int[]{1, 2, 1})).forEach(System.out::print);
    }


    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                stack.pop();
            }

            res[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }

        return res;
    }

}
