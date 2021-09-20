package leetcode.medium;

/**
 * ���������� �ǵݼ�˳�� ���е���������?nums1 �� nums2�������������� m �� n ���ֱ��ʾ nums1 �� nums2 �е�Ԫ����Ŀ��
 * <p>
 * ���� �ϲ� nums2 �� nums1 �У�ʹ�ϲ��������ͬ���� �ǵݼ�˳�� ���С�
 * <p>
 * ע�⣺���գ��ϲ������鲻Ӧ�ɺ������أ����Ǵ洢������ nums1 �С�Ϊ��Ӧ�����������nums1 �ĳ�ʼ����Ϊ m + n��
 * ����ǰ m ��Ԫ�ر�ʾӦ�ϲ���Ԫ�أ��� n ��Ԫ��Ϊ 0 ��Ӧ���ԡ�nums2 �ĳ���Ϊ n ��
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums2.length == 0) {
            return;
        }

        int[] srcNums1 = new int[m];
        System.arraycopy(nums1, 0, srcNums1, 0, m);

        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < m || index2 < n) {
            if (index1 == m) {
                System.arraycopy(nums2, index2, nums1, index, n - index2);
                break;
            }

            if (index2 == n) {
                System.arraycopy(srcNums1, index1, nums1, index, m - index1);
                break;
            }

            if (srcNums1[index1] < nums2[index2]) {
                nums1[index++] = srcNums1[index1++];
            } else {
                nums1[index++] = nums2[index2++];
            }
        }
    }

}
