package com.zxt.dynamic.program;

/**
 * @Description: ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 * �����ַ�����ֻ�����ӡ�a������z�����ַ������磬���ַ����С�arabcacfr��������ظ����ַ���Ϊ��acfr��������Ϊ4��
 * @author�� zxt
 * @time: 2018��7��14�� ����5:39:56
 */
public class ������ظ��ַ������ַ��� {
    // ������Ŀ�涨�ַ�����ֻ����a-z���ַ������Զ���һ������Ϊ26�����飬�����ַ����±꣨��һ�γ��֣�����ͬ�ַ����±��Ȼ��ͬ
    private static int[] position = new int[26];

    public static void main(String[] args) {
        System.out.println(getMaxSubStr("arabcacfr"));

        System.out.println(getMaxSubStr(""));

        System.out.println(getMaxSubStr("abcdef"));

        System.out.println(getMaxSubStr("aaaaaa"));
    }

    /**
     * @param str
     * @return
     * @Description������f(i)��ʾ�Ե�i���ַ�Ϊ��β�Ĳ������ظ��ַ������ַ����������
     */
    public static int getMaxSubStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // ����Ĭ�����е��ַ�����û�г��֣��������ǵ��±궼Ϊ-1
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        // ������ظ��ַ������ַ���
        int maxLength = 0;
        // �Ե�ǰ�ַ���β�Ĳ����ظ��ַ������ַ�������
        int curLength = 0;

        for (int i = 0; i < str.length(); i++) {
            // �жϵ�ǰ�ַ�ǰһ�γ��ֵ�λ��
            int preIndex = position[str.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > curLength) {
                // preIndex < 0����-1����ʾ���ַ�ǰ��û�г��ֹ��������Ե�i���ַ���β�Ĳ����ظ��ַ������ַ������� Ϊ�Ե�i-1���ַ���β�ĳ���+1
                // i - preIndex > curLength����ʾ��i���ַ����ֹ������ǳ����� �Ե�i-1���ַ���β���Ӵ����Ⱦ����ǰ�棨�����Ӵ��������ظ��ַ���
                ++curLength;

            } else {
                // ���ַ����ֹ����ҳ������Ե�i-1���ַ���β���Ӵ�����
                if (curLength > maxLength) {
                    maxLength = curLength;
                }

                // �����Ե�i���ַ���β���Ӵ�����Ϊ��ǰλ�õ����ظ��ַ�ǰ����ֵ�λ�õľ���
                curLength = i - preIndex;
            }

            // ��¼��ǰ�ַ����ֵ�λ��
            position[str.charAt(i) - 'a'] = i;
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }
}
