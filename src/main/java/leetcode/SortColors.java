package leetcode;

/**
 * ����һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
 * <p>
 * �����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
 */
public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] == 0) {
                left++;
            }

            while (nums[right] == 2) {
                right--;
            }

            if (left != right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    public static void sortColors1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i < twoIndex + 1; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex++] = temp;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[twoIndex];
                nums[twoIndex--] = temp;
                i--;
            }
        }

    }
}
