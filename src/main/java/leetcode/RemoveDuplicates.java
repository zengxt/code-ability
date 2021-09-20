package leetcode;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums1));
        Arrays.stream(nums1).forEach(System.out::print);
        System.out.println();

        System.out.println("============================");
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums2));
        Arrays.stream(nums2).forEach(System.out::print);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (index < 2 || nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
