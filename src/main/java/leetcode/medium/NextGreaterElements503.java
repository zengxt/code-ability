package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����һ��ѭ�����飨���һ��Ԫ�ص���һ��Ԫ��������ĵ�һ��Ԫ�أ������ÿ��Ԫ�ص���һ������Ԫ�ء�
 * ���� x ����һ�������Ԫ���ǰ��������˳���������֮��ĵ�һ�������������������ζ����Ӧ��ѭ��������������һ�����������
 * ��������ڣ������ -1��
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
