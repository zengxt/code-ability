package leetcode;

/**
 * 给定一个包含红色、白色和蓝色，一共?n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、?1 和 2 分别表示红色、白色和蓝色。
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
