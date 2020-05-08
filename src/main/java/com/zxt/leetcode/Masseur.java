package com.zxt.leetcode;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * <p>
 */
public class Masseur {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(massage(arr));
    }

    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        // 定义一个数组，time[i] 表示以nums[i]为结尾的预约，能得到的最优预约总时间
        int[] time = new int[nums.length];
        time[0] = nums[0];
        time[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            // 以 0， 1， 2 三个 位置为例，如果选了第0个，那么就不能选第1个，所以 time[2] = nums[2] + time[0]
            // 而 time[1] 可以理解为选了第1个，那么第2个就不可选，所以就是 time[2] = time[1];
            // 但是实际上 time[1] 并不表示就选了 第1个，有可能第0个比较大，选的第0个，
            // 那这样的话，就和 time[2] = nums[2] + time[0]一样了 （time[1]有两种情况）
            time[i] = Math.max(nums[i] + time[i - 2], time[i - 1]);
        }

        return time[time.length - 1];


//        return getMaxTime(nums, 0);
    }

    // 时间复杂度太高，通不过
    public static int getMaxTime(int[] nums, int index) {
        if (nums == null || index >= nums.length) {
            return 0;
        }

        if (index == nums.length - 1) {
            return nums[nums.length - 1];
        }

        return Math.max(nums[index] + getMaxTime(nums, index + 2), getMaxTime(nums, index + 1));
    }
}
