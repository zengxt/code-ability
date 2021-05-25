package leetcode.simple;

import java.util.Arrays;

/**
 * δ֪ �������� arr �� n ���Ǹ�������ɡ�
 * <p>
 * ��������Ϊ����Ϊ n - 1 ����һ���������� encoded ������ encoded[i] = arr[i] XOR arr[i + 1] ��
 * ���磬arr = [1,0,2,1] �������õ� encoded = [1,2,3] ��
 * <p>
 * ������������� encoded ��ԭ���� arr �ĵ�һ��Ԫ�� first��arr[0]����
 * <p>
 * ����뷵��ԭ���� arr ������֤���𰸴��ڲ�����Ψһ�ġ�
 */
public class ExclusiveOR1720 {
    public static void main(String[] args) {
        Arrays.stream(decode(new int[]{1, 2, 3}, 1)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(decode(new int[]{6, 2, 7, 3}, 4)).forEach(System.out::print);
    }

    public static int[] decode(int[] encoded, int first) {
        if (encoded == null) {
            return null;
        }

        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }

        return result;
    }
}
