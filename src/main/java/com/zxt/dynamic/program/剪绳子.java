package com.zxt.dynamic.program;

/**
 * @Description: 给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1并且m>1），每段绳子的长度记为k[0] ，k[1]，……，k[m]。
 * 请问k[0]*k[1]*……*k[m]可能的最大乘积是多少？例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到最大乘积是18。
 * @author： zxt
 * @time: 2018年6月28日 上午9:31:29
 */
public class 剪绳子 {

    public static void main(String[] args) {
        剪绳子 test = new 剪绳子();

        System.out.println(test.maxProductAfterCutting(5));
        System.out.println(test.maxProductAfterCutting(6));
        System.out.println(test.maxProductAfterCutting(8));
        System.out.println(test.maxProductAfterCutting(12));
    }

    /**
     * @param length
     * @return
     * @Description：长度为length的绳子被剪成若干段后的最大乘积
     */
    public int maxProductAfterCutting(int length) {
        // 绳子长度小于4，可以直接返回
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        // 子问题最优解存储在数组products中
        int[] products = new int[length + 1];
        // 由于绳子长度小于4已经直接返回了，绳子长度从4开始，4可以剪成2*2和1*3,2*2大
        // 因此products   0-3存储的是初始条件，即绳子的长度。   i > 4时，products[i]：表示长度为i的绳子剪成若干段之后乘积的最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        // 绳子长度从4开始计算
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            // 所有可能的f(j)*f(i-j)并比较得出他们的最大值
            for (int j = 0; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }

            products[i] = max;
        }

        return products[length];
    }
}
