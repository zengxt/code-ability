package leetcode.simple;

/**
 * ���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ�����ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣
 * ����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
 * <p>
 * �������� n ���汾 [1, 2, ..., n]�������ҳ�����֮�����а汾����ĵ�һ������İ汾��
 * <p>
 * �����ͨ������?bool isBadVersion(version)?�ӿ����жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���
 * ʵ��һ�����������ҵ�һ������İ汾����Ӧ�þ������ٶԵ��� API �Ĵ�����
 * <p>
 */
public class FirstBadVersion278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
        System.out.println(firstBadVersion(1));
    }


    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private static boolean isBadVersion(int version) {
        return false;
    }
}
