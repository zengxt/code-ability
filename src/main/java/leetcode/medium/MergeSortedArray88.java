package leetcode.medium;

/**
 * 给你两个按 非递减顺序 排列的整数数组?nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums2.length == 0) {
            return;
        }

        int[] srcNums1 = new int[m];
        System.arraycopy(nums1, 0, srcNums1, 0, m);

        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < m || index2 < n) {
            if (index1 == m) {
                System.arraycopy(nums2, index2, nums1, index, n - index2);
                break;
            }

            if (index2 == n) {
                System.arraycopy(srcNums1, index1, nums1, index, m - index1);
                break;
            }

            if (srcNums1[index1] < nums2[index2]) {
                nums1[index++] = srcNums1[index1++];
            } else {
                nums1[index++] = nums2[index2++];
            }
        }
    }

}
