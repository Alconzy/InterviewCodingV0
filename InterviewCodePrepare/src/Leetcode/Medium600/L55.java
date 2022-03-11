package Leetcode.Medium600;

public class L55 {
   // https://leetcode.com/problems/jump-game/
   public boolean canJump(int[] nums) {
       //写法 1 -- 更容易理解 我的写法有所不同 参考 https://github.com/liweiwei1419/LeetCode-Solutions-in-Good-Style/blob/master/15-Greedy-Algorithm/0055-jump-game/src/Solution.java  我的写法有所不同
       //假设 2 1 1 1
       //len表示终点位置index
       int len = nums.length - 1;
       int maxReach = 0;
       //i 从 0 到 3， 用于判断能否到达当前位置 i-th
       for (int i = 0; i <= len; i++) {
           if (maxReach < i) {
               return false;
           }
           maxReach = Math.max(maxReach, i + nums[i]);
       }
       return true;
   }


    /**
     写法2 --
     //https://labuladong.gitee.io/algo/3/28/107/
     int targetSteps = nums.length - 1;
     int curMax = 0;
     for (int i = 0; i < nums.length - 1; i++) {
     curMax = Math.max(curMax, i + nums[i]);
     if (curMax <= i)
     return false;
     }
     return curMax >= targetSteps;

     **/
}
