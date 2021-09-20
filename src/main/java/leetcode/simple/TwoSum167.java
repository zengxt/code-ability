package leetcode.simple;

import java.util.Arrays;

/**
 * ����һ���Ѱ��� ��������? ����������?numbers ��������������ҳ��������������֮�͵���Ŀ����?target ��
 * <p>
 * ����Ӧ���Գ���Ϊ 2 �������������ʽ���������������±�ֵ��numbers ���±� �� 1 ��ʼ���� ��
 * ���Դ�����Ӧ������ 1 <= answer[0] < answer[1] <= numbers.length ��
 * <p>
 * ����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
 */
public class TwoSum167 {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::print);
        Arrays.stream(twoSum(new int[]{2, 3, 4}, 6)).forEach(System.out::print);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int left = 0;
        int right = numbers.length - 1;
        int[] ans = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }

}
