package com.zxt.dynamic.program;

/**
 * @Description: 01背包问题：有n 个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 * <p>
 * eg：背包容量：capacity = 8
 * 物体体积与价值：volume/value：2/3、3/4、4/5、5/6
 * <p>
 * 这题的解法与国王与金矿的解法完全一样，每个物体都有两种选择，放入背包与不放，然后计算这两种选择的最大价值
 * @author： zxt
 * @time: 2018年7月2日 下午8:20:35
 */
public class 背包问题01 {

    public static void main(String[] args) {
        int capacity = 8;
        int[] volume = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 6};

        System.out.println(getMaxValue(capacity, volume, value));
    }

    /**
     * @param capacity
     * @param volume
     * @param value
     * @return
     * @Description：自底向上填表格：（i，j）表示由i件物品，j体积的最大价值
     */
    public static int getMaxValue(int capacity, int[] volume, int[] value) {

        // i-1件物品时，最大的价值
        int[] preMaxValue = new int[capacity + 1];
        int[] maxValue = new int[capacity + 1];

        // 初始化，表示一件物品j容量是的最大价值
        for (int j = 1; j <= capacity; j++) {
            // 当前体积不够放第一件物品
            if (j < volume[0]) {
                preMaxValue[j] = 0;
            } else {
                preMaxValue[j] = value[0];
            }
        }

        // i件物品，j容量的最大价值
        for (int i = 1; i < volume.length; i++) {

            for (int j = 1; j <= capacity; j++) {
                if (j < volume[i]) {
                    maxValue[j] = preMaxValue[j];

                } else {
                    // 容量足够就有了放入背包与不放入背包两种选择
                    maxValue[j] = Math.max(preMaxValue[j], preMaxValue[j - volume[i]] + value[i]);
                }
            }

            // 保留i-1件物品时，最大的价值
            for (int k = 1; k <= capacity; k++) {
                preMaxValue[k] = maxValue[k];
            }
        }

        return maxValue[capacity];
    }
}
