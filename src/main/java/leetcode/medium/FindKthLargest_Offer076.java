package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
 * <p>
 * ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 * <p>
 * ʾ��?2:
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 */
public class FindKthLargest_Offer076 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }

        int res = 0;
        while (k > 0) {
            res = queue.poll();
            k--;
        }

        return res;
    }

}
