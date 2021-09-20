package leetcode.simple;

import java.util.Arrays;

/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
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
