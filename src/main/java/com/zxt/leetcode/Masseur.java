package com.zxt.leetcode;

/**
 * һ�������İ�Ħʦ���յ�ԴԴ���ϵ�ԤԼ����ÿ��ԤԼ������ѡ��ӻ򲻽ӡ���ÿ��ԤԼ����֮��Ҫ����Ϣʱ�䣬��������ܽ������ڵ�ԤԼ��
 * ����һ��ԤԼ�������У��水Ħʦ�ҵ����ŵ�ԤԼ���ϣ���ԤԼʱ������������ܵķ�������
 * <p>
 * ���룺 [1,2,3,1]
 * ����� 4
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ����ʱ�� = 1 + 3 = 4��
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

        // ����һ�����飬time[i] ��ʾ��nums[i]Ϊ��β��ԤԼ���ܵõ�������ԤԼ��ʱ��
        int[] time = new int[nums.length];
        time[0] = nums[0];
        time[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            // �� 0�� 1�� 2 ���� λ��Ϊ�������ѡ�˵�0������ô�Ͳ���ѡ��1�������� time[2] = nums[2] + time[0]
            // �� time[1] �������Ϊѡ�˵�1������ô��2���Ͳ���ѡ�����Ծ��� time[2] = time[1];
            // ����ʵ���� time[1] ������ʾ��ѡ�� ��1�����п��ܵ�0���Ƚϴ�ѡ�ĵ�0����
            // �������Ļ����ͺ� time[2] = nums[2] + time[0]һ���� ��time[1]�����������
            time[i] = Math.max(nums[i] + time[i - 2], time[i - 1]);
        }

        return time[time.length - 1];


//        return getMaxTime(nums, 0);
    }

    // ʱ�临�Ӷ�̫�ߣ�ͨ����
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
