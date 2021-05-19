package leetcode.simple;

/**
 * ����һ������������?arr?������������п��ܵ���������������ĺ͡�
 * <p>
 * ������ ����Ϊԭ�����е�һ�����������С�
 * <p>
 * ���㷵�� arr?�� ������������������ĺ� ��
 */
public class SumOfAllOddLengthSubArrays1588 {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println(sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];  // ����Ϊ1��������
            int index = i;
            // �� arr[i] ��ͷ������������
            while (index + 2 < arr.length) {
                for (int j = i; j <= index + 2; j++) {
                    result += arr[j];
                }
                index += 2;
            }
        }

        return result;
    }
}
