package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ��һЩ������difficulty[i]?��ʾ�� i ���������Ѷȣ�profit[i] ��ʾ�� i �����������档
 * <p>
 * ����������һЩ���ˡ�worker[i] �ǵ� i �����˵����������ù���ֻ������Ѷ�С�ڵ��� worker[i] �Ĺ�����
 * <p>
 * ÿһ�����˶����ֻ�ܰ���һ������������һ������������ɶ�Ρ�
 * <p>
 * �ٸ����ӣ���� 3 �����˶��������һ�ݱ���Ϊ 1 ��ͬ����������ô������Ϊ $3�����һ�����˲�������κι�������������Ϊ $0 ��
 * <p>
 * �����ܵõ�����������Ƕ��٣�
 * <p>
 * ʾ����
 * ����: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * ���: 100
 * ����: ���˱�����Ĺ����Ѷ��� [4,4,6,6] ���ֱ��� [20,20,30,30] �����档
 */
public class JobMaxProfit {
    public static void main(String[] args) {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        JobMaxProfit JobMaxProfit = new JobMaxProfit();
        System.out.println(JobMaxProfit.maxProfitAssignment(difficulty, profit, worker));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }

        // �������Ѷȴ�С��������Ӵ�С����
        jobs.sort((o1, o2) -> {
            if (o1.difficult != o2.difficult) {
                return o1.difficult - o2.difficult;
            } else {
                return o2.profit - o1.profit;
            }
        });

        // ͬһ�Ѷȣ�����͵��ų��� �Ѷȸ������淴�����͵�Ҳ�ų�
        Iterator<Job> iterator = jobs.iterator();
        int preDif = Integer.MIN_VALUE;
        int prePro = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            Job next = iterator.next();
            if (preDif == next.difficult || prePro > next.profit) {
                iterator.remove();
            } else {
                preDif = next.difficult;
                prePro = next.profit;
            }
        }

        Job[] jobArr = new Job[jobs.size()];
        for (int i = 0; i < jobs.size(); i++) {
            jobArr[i] = jobs.get(i);
        }

        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            result += binSearch(jobArr, worker[i]);
//            for (int j = jobs.size() - 1; j >= 0; j--) {
//                if (jobs.get(j).difficult <= worker[i]) {
//                    result += jobs.get(j).profit;
//                    break;
//                }
//            }
        }

        return result;
    }

    private int binSearch(Job[] jobs, int difficult) {
        int left = 0;
        int right = jobs.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].difficult <= difficult) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0) {
            return 0;
        }
        return jobs[left == 0 ? 0 : left - 1].profit;
    }

    class Job {
        int difficult;
        int profit;

        Job(int difficult, int profit) {
            this.difficult = difficult;
            this.profit = profit;
        }
    }

}
