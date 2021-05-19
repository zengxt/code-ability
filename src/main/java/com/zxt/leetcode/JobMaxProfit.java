package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 有一些工作：difficulty[i]?表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * 示例：
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
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

        // 按工作难度从小到大，收益从大到小排序
        jobs.sort((o1, o2) -> {
            if (o1.difficult != o2.difficult) {
                return o1.difficult - o2.difficult;
            } else {
                return o2.profit - o1.profit;
            }
        });

        // 同一难度，收益低的排除， 难度更大收益反而更低的也排除
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
