package leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();

        System.out.println("====================================");
        int[] nums1 = new int[]{-1, -100, 3, 99};
        rotate(nums1, 2);
        Arrays.stream(nums1).forEach(System.out::print);
        System.out.println();

        System.out.println("====================================");
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
        rotate(nums2, 3);
        Arrays.stream(nums2).forEach(System.out::print);
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;
        int count = gcd(k, nums.length);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int pre = nums[start];
            do {
                int temp = nums[(start + k) % nums.length];
                nums[start = ((start + k) % nums.length)] = pre;
                pre = temp;
            } while (start != current);
        }
    }

    private static int gcd(int m, int n) {
        return n > 0 ? gcd(n, m % n) : m;
    }

    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


}
