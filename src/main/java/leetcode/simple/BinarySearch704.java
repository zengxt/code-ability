package leetcode.simple;

/**
 * 给定一个?n?个元素有序的（升序）整型数组?nums 和一个目标值?target ?，写一个函数搜索?nums?中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class BinarySearch704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }


    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0
                || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
