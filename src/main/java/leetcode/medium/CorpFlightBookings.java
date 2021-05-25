package leetcode.medium;

import java.util.Arrays;

/**
 * 这里有?n?个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表?bookings ，表中第?i?条预订记录?bookings[i] = [firsti, lasti, seatsi]?
 * 意味着在从 firsti?到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi?个座位。
 * <p>
 * 请你返回一个长度为 n 的数组?answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * <p>
 */
public class CorpFlightBookings {
    public static void main(String[] args) {
        Arrays.stream(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)).forEach(System.out::print);
    }

    /**
     * 1、换一种思路理解题意，将问题转换为：某公交车共有 n 站，第 i 条记录 bookings[i] = [i, j, k]
     * 表示在 i 站上车 k 人，乘坐到 j 站，在 j+1 站下车，需要按照车站顺序返回每一站车上的人数
     * 2、根据 1 的思路，定义 counter[] 数组记录每站的人数变化，counter[i] 表示第 i+1 站。
     * 遍历 bookings[]：bookings[i] = [i, j, k] 表示在 i 站增加 k 人即 counters[i-1] += k，在 j+1 站减少 k 人即 counters[j] -= k
     * 3、遍历（整理）counter[] 数组，得到每站总人数： 每站的人数为前一站人数加上当前人数变化 counters[i] += counters[i - 1]
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
