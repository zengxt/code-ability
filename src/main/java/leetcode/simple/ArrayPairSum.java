package leetcode.simple;

import java.util.Arrays;

/**
 * ��������Ϊ?2n?���������� nums ����������ǽ���Щ���ֳ�?n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��
 * ʹ�ô� 1 ��?n �� min(ai, bi) �ܺ���󡣷��ظ� ����ܺ� ��
 * <p>
 * <p>
 * ʾ�� 1��
 * ���룺nums = [1,4,3,2]
 * �����4
 * ���ͣ����п��ܵķַ�������Ԫ��˳��Ϊ��
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * ��������ܺ�Ϊ 4
 * <p>
 * ʾ�� 2��
 * ���룺nums = [6,2,6,5,1,2]
 * �����9
 * ���ͣ����ŵķַ�Ϊ (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }

        return result;
    }
}
