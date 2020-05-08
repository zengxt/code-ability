package com.zxt.dynamic.program;

/**
 * @Description: 01�������⣺��n ����Ʒ�������и��Ե������ͼ�ֵ�����и��������ı���������ñ�����װ�����Ʒ�������ļ�ֵ�ܺͣ�
 * <p>
 * eg������������capacity = 8
 * ����������ֵ��volume/value��2/3��3/4��4/5��5/6
 * <p>
 * ����Ľⷨ���������Ľⷨ��ȫһ����ÿ�����嶼������ѡ�񣬷��뱳���벻�ţ�Ȼ�����������ѡ�������ֵ
 * @author�� zxt
 * @time: 2018��7��2�� ����8:20:35
 */
public class ��������01 {

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
     * @Description���Ե��������񣺣�i��j����ʾ��i����Ʒ��j���������ֵ
     */
    public static int getMaxValue(int capacity, int[] volume, int[] value) {

        // i-1����Ʒʱ�����ļ�ֵ
        int[] preMaxValue = new int[capacity + 1];
        int[] maxValue = new int[capacity + 1];

        // ��ʼ������ʾһ����Ʒj�����ǵ�����ֵ
        for (int j = 1; j <= capacity; j++) {
            // ��ǰ��������ŵ�һ����Ʒ
            if (j < volume[0]) {
                preMaxValue[j] = 0;
            } else {
                preMaxValue[j] = value[0];
            }
        }

        // i����Ʒ��j����������ֵ
        for (int i = 1; i < volume.length; i++) {

            for (int j = 1; j <= capacity; j++) {
                if (j < volume[i]) {
                    maxValue[j] = preMaxValue[j];

                } else {
                    // �����㹻�����˷��뱳���벻���뱳������ѡ��
                    maxValue[j] = Math.max(preMaxValue[j], preMaxValue[j - volume[i]] + value[i]);
                }
            }

            // ����i-1����Ʒʱ�����ļ�ֵ
            for (int k = 1; k <= capacity; k++) {
                preMaxValue[k] = maxValue[k];
            }
        }

        return maxValue[capacity];
    }
}
