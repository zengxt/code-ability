package com.zxt.dynamic.program;

/**
 * @Description: 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 * @author： zxt
 * @time: 2018年6月30日 上午11:32:05
 */
public class 走楼梯 {

    public static void main(String[] args) {
        System.out.println(getClimbingWays(5));
    }

    public static int getClimbingWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int f1 = 1;
        int f2 = 2;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }

        return result;
    }
}
