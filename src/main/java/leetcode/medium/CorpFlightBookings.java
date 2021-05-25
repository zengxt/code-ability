package leetcode.medium;

import java.util.Arrays;

/**
 * ������?n?�����࣬���Ƿֱ�� 1 �� n ���б�š�
 * <p>
 * ��һ�ݺ���Ԥ����?bookings �����е�?i?��Ԥ����¼?bookings[i] = [firsti, lasti, seatsi]?
 * ��ζ���ڴ� firsti?�� lasti ������ firsti �� lasti ���� ÿ������ ��Ԥ���� seatsi?����λ��
 * <p>
 * ���㷵��һ������Ϊ n ������?answer������ answer[i] �Ǻ��� i ��Ԥ������λ������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * �����[10,55,45,25,25]
 * ���ͣ�
 * ������        1   2   3   4   5
 * Ԥ����¼ 1 ��   10  10
 * Ԥ����¼ 2 ��       20  20
 * Ԥ����¼ 3 ��       25  25  25  25
 * ����λ����      10  55  45  25  25
 * ��ˣ�answer = [10,55,45,25,25]
 * <p>
 */
public class CorpFlightBookings {
    public static void main(String[] args) {
        Arrays.stream(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)).forEach(System.out::print);
    }

    /**
     * 1����һ��˼·������⣬������ת��Ϊ��ĳ���������� n վ���� i ����¼ bookings[i] = [i, j, k]
     * ��ʾ�� i վ�ϳ� k �ˣ������� j վ���� j+1 վ�³�����Ҫ���ճ�վ˳�򷵻�ÿһվ���ϵ�����
     * 2������ 1 ��˼·������ counter[] �����¼ÿվ�������仯��counter[i] ��ʾ�� i+1 վ��
     * ���� bookings[]��bookings[i] = [i, j, k] ��ʾ�� i վ���� k �˼� counters[i-1] += k���� j+1 վ���� k �˼� counters[j] -= k
     * 3������������counter[] ���飬�õ�ÿվ�������� ÿվ������Ϊǰһվ�������ϵ�ǰ�����仯 counters[i] += counters[i - 1]
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        if (bookings == null || bookings[0].length == 0) {
            return result;
        }

        for (int[] booking : bookings) {
            result[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                result[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            result[i] = result[i] + result[i - 1];
        }

        return result;
    }

}
