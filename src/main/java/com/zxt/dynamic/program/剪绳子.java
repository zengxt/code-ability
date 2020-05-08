package com.zxt.dynamic.program;

/**
 * @Description: ����һ������Ϊn�����ӣ�������Ӽ���m�Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊk[0] ��k[1]��������k[m]��
 * ����k[0]*k[1]*����*k[m]���ܵ����˻��Ƕ��٣����磬�����ӵĳ���Ϊ8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2,3,3�����Σ���ʱ�õ����˻���18��
 * @author�� zxt
 * @time: 2018��6��28�� ����9:31:29
 */
public class ������ {

    public static void main(String[] args) {
        ������ test = new ������();

        System.out.println(test.maxProductAfterCutting(5));
        System.out.println(test.maxProductAfterCutting(6));
        System.out.println(test.maxProductAfterCutting(8));
        System.out.println(test.maxProductAfterCutting(12));
    }

    /**
     * @param length
     * @return
     * @Description������Ϊlength�����ӱ��������ɶκ�����˻�
     */
    public int maxProductAfterCutting(int length) {
        // ���ӳ���С��4������ֱ�ӷ���
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        // ���������Ž�洢������products��
        int[] products = new int[length + 1];
        // �������ӳ���С��4�Ѿ�ֱ�ӷ����ˣ����ӳ��ȴ�4��ʼ��4���Լ���2*2��1*3,2*2��
        // ���products   0-3�洢���ǳ�ʼ�����������ӵĳ��ȡ�   i > 4ʱ��products[i]����ʾ����Ϊi�����Ӽ������ɶ�֮��˻������ֵ
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        // ���ӳ��ȴ�4��ʼ����
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            // ���п��ܵ�f(j)*f(i-j)���Ƚϵó����ǵ����ֵ
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
