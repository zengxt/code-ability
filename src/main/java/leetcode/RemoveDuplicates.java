package leetcode;

import java.util.Arrays;

/**
 * ����һ���������� nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ���������� ������ɾ����������³��ȡ�
 * <p>
 * ��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�
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
