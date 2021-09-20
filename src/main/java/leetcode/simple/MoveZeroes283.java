package leetcode.simple;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = 0;
        int index = 0;
        while (index < nums.length) {
            while (zeroIndex < nums.length && nums[zeroIndex] != 0) {
                zeroIndex++;
            }

            index = zeroIndex + 1;
            while (index < nums.length && nums[index] == 0) {
                index++;
            }

            if (index < nums.length) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[index];
                nums[index] = temp;
            }
        }
    }
}
