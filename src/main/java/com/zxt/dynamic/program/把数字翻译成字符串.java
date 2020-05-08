package com.zxt.dynamic.program;

/**
 * @Description: ����һ�����֣��������¹�������ַ�����0����ɡ�a����1����ɡ�b��...25����ɡ�z����
 * һ�������ж��ַ�����ܣ�����12258һ����5�֣��ֱ���bccfi��bwfi��bczi��mcfi��mzi��ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 * <p>
 * ˼·����12258Ϊ��������1���Ե��������b������ʣ��2258�� 1Ҳ���Ժ�2һ�����m������ʣ��258����˿����õݹ�ⷨ�������������ظ�����
 * <p>
 * ��Ȼ�ݹ������������ظ����Ǿʹ�С���⿪ʼ�Ե����ϣ�������������
 * @author�� zxt
 * @time: 2018��8��20�� ����11:41:10
 */
public class �����ַ�����ַ��� {

    public static void main(String[] args) {
        int n = 122581231;
        System.out.println(getTranslationCount(n));
        System.out.println(getTranslationCount2(n));
    }

    /**
     * @param n
     * @return
     * @Description���ݹ�ʵ�֣���12258Ϊ��������1���Ե��������b������ʣ��2258�� 1Ҳ���Ժ�2һ�����m������ʣ��258
     */
    public static int getTranslationCount(int n) {
        if (n < 0) {
            return 0;
        }

        return getTranslationCount("" + n, 0);
    }

    public static int getTranslationCount(String str, int start) {
        if (str == null || start > str.length()) {
            return 0;
        }

        if (str.length() == 0 || start == str.length() - 1 || start == str.length()) {
            return 1;
        }

        // ��ǰ���ֵ�������
        int result1 = getTranslationCount(str, start + 1);
        // �ж��Ƿ���Ժ���һ��λ����Ϸ���
        int result2 = 0;
        if (start + 1 <= str.length() - 1) {
            String temp = str.substring(start, start + 2);
            int value = Integer.valueOf(temp);
            if (10 <= value && value <= 25) {
                result2 = getTranslationCount(str, start + 2);
            }
        }

        return result1 + result2;
    }

    /**
     * @param n
     * @return
     * @Description����̬�滮�ⷨ
     */
    public static int getTranslationCount2(int n) {
        if (n < 0) {
            return 0;
        }

        return getTranslationCount2("" + n);
    }

    public static int getTranslationCount2(String str) {
        int length = str.length();
        int[] counts = new int[length];
        int count = 0;

        for (int i = length - 1; i >= 0; i--) {
            count = 0;

            if (i == length - 1) {
                count = 1;
            } else {
                count = counts[i + 1];
            }

            if (i < length - 1) {
                int currDigit = str.charAt(i) - '0';
                int nextDigit = str.charAt(i + 1) - '0';
                int converted = currDigit * 10 + nextDigit;
                if (10 <= converted && converted <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        return counts[0];
    }

}
