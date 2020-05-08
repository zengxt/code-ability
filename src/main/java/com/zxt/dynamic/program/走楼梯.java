package com.zxt.dynamic.program;

/**
 * @Description: ��һ���߶���10��̨�׵�¥�ݣ����������ߣ�ÿ��һ��ֻ������1������2��̨�ס�Ҫ���ó��������һ���ж������߷���
 * @author�� zxt
 * @time: 2018��6��30�� ����11:32:05
 */
public class ��¥�� {

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
