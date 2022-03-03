package Leetcode.Medium600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L911 {
    /**
     * 思路参考：https://leetcode-cn.com/problems/online-election/solution/gong-shui-san-xie-er-fen-yun-yong-ti-by-5y3hi/
     *
     * 根据题意，我们会在 times[i]times[i] 时刻为 persons[i]persons[i] 候选人增加一票。
     *
     * 利用 timestimes 数组严格递增，我们可以在处理 timestimes 时（模拟加票过程），使用一个变量 valval 来维护当前得票的最大数量，使用 listlist 来记录不同时刻点的候选人交替情况。
     *
     * 起始时 val = 0val=0，当出现票数大于等于 valval 时，我们往 listlist 追加二元组记录 list[idx] = (times[i], persons[i])list[idx]=(times[i],persons[i])，并更新 valval。
     *
     * 每个 list[idx]list[idx] 代表了当前候选人 list[idx][1]list[idx][1] 的首次当选时刻为 list[idx][0]list[idx][0]。
     *
     * 举个 🌰，若 i = list[idx][0], j = list[idx + 1][0]i=list[idx][0],j=list[idx+1][0]，则意味着在时间段 [i, j)[i,j) 内当选的候选人为 list[idx][1]list[idx][1]。
     *
     * 在查询时，我们只需要通过「二分」找到 listlist 中满足 list[i][0] <= tlist[i][0]<=t 的分割点 rr（最大下标），取 list[r][1]list[r][1] 即是答案。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/online-election/solution/gong-shui-san-xie-er-fen-yun-yong-ti-by-5y3hi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //list存储每一次票选交替情况, global variable 后面function q() 要用
    List<int[]> list = new ArrayList<>();
    public L911(int[] persons, int[] times) {
        //map 存储 在 times[i] 时刻，person[i] vote 递增
        Map<Integer, Integer> hashmap = new HashMap<>();
        int val = 0;
        //store vote at time i-th in hashmap
        // and store the current leading at i-th in list
        for (int i = 0; i < times.length; i++) {
            hashmap.put(persons[i], hashmap.getOrDefault(persons[i], 0) + 1);
            if (hashmap.get(i) >= val) {
                val = hashmap.get(i);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int l = 0, r = list.size() - 1;
        //find the right most (largest index) at time t
        while(l < r) {
            //or 用 bit-operation int mid = l + r + 1 >> 1;
            int mid = l + (r - l) / 2;
            if (list.get(mid)[0] <= t)
                l = mid;
            else
                r = mid - 1;
        }
        //when reach here, l and r are neghbour
        //0 means 找不到
        return list.get(l)[0] <= t? list.get(l)[1] : 0;
    }
}
