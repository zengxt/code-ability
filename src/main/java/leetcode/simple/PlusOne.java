package leetcode.simple;

import java.util.Arrays;

/**
 * ����һ���� ���� ��ɵ� �ǿ� ��������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
 * <p>
 * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
 * <p>
 * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 */
public class PlusOne {
    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[]{1, 2, 3})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(plusOne(new int[]{9})).forEach(System.out::print);
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int bit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + bit;
            digits[i] = temp == 10 ? 0 : temp;
            bit = temp == 10 ? 1 : 0;

            if (bit == 0) {
                break;
            }
        }

        if (bit == 0) {
            return digits;
        } else {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = 1;
            return ans;
        }

    }
}
