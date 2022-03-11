package Leetcode.Medium600.DP;

/**
 * 好文参考：
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
 */
public class L983 {
    // 比较规整且好理解的答案
    // https://github.com/liweiwei1419/LeetCode-Solutions-in-Good-Style/blob/master/13-Dynamic-Programming-1/13-4-No-Aftereffect/0983-minimum-cost-for-tickets/src/Solution.java

    /**
     /**
     * 自己分析 （第一遍）
     *  /**
     *         design dp[i] : the minimum cost if travel from day i-th to the end of the year,
     *         because if buy ticket at day i, then i + j would be covered (j belongs to 1, 7, 30)
     *
     *         "backtrack dp"
     *
     *         therefore,
     *
     *         dp[i] =
     *             case 1, day i-th no travel, dp[i] = dp[i - 1];
     *             case 2, day i-th has travel,
     *                 case 2.1  buy one day
     *                         dp[i] = dp[i - 1] + cost[0]
     *
     *                 case 2.2 buy 7 days
     *                         dp[i] = dp[i - 7] + cost[1]  //notice that i - 7 could be negative which does                                              not make sense, use max(0, i - 7) to gurantee cost must >= 0
     *
     *                 case 2.3 buy 30 days
     *                         dp[i] = dp[i - 30] + cost[2]
     *
     *                 so, we want to find the mininum cost among three cases above
     *
     *                 Math.min(case2.1, case2.2, case2.3);
     *
     *
     *                 补充：1.找day[i] 是否有 plan 可以用array 充当hashset, 或者直接用hashset
     *
     *                      2.注意 边界， 比如， 当 i-th （i = 8) 天 买了 7 天票， 则 2 3 4 5 6 7 8都免， 从dp[1-th] (day 1-th 开始算)
     *
     *                      3.不同考虑方式不一样dp[i] (正dp, 反向dp)
     *                          3.1 dp[i]: // dp[i]：到下标为 i 的这一天，旅行所需要的最低消费
     *                          3.2 dp[i]: //dp[i]：i-th day 到 maxDay (days[days.len - 1]) 旅行所需要的最低消费
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len - 1];

        // 数组的作用是代替哈希表，以便后续快速检测是否当天有旅行
        int[] hashMap = new int[366];
        for (int day : days) {
            hashMap[day]++;
        }

        // dp[i]：到下标为 i 的这一天，旅行所需要的最低消费
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (hashMap[i] == 1) {
                dp[i] = min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

//    //todo 第二种不需要用新array 构造 hashmap 的方法 解析
//    int len = days.length, maxDay = days[len - 1], minDay = days[0];
//    int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制
//    // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
//        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
//        // i 表示 days 的索引
//        // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
//        if (d == days[i]) {
//            dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
//            dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
//            i--; // 别忘了递减一天
//        } else dp[d] = dp[d + 1]; // 不需要出门
//    }
//        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
}
