package 限时15分钟练习最基础代码能力的题目;

//https://leetcode-cn.com/problems/max-consecutive-ones-iii/
public class L1004 {
        public int longestOnes(int[] nums, int k) {
            //sliding window
            //11000111
            int slow = 0, fast = 0, res = 0, zeroCount = 0;
            while (fast < nums.length) {
                if (nums[fast] == 0) {
                    zeroCount++;
                }
                while (zeroCount > k) {
                    if (nums[slow] == 0) {
                        zeroCount--;
                    }
                    slow++;
                }
                res = Math.max(res, fast - slow + 1);
                fast++;
            }
            return res;
        }
    // public int findMaxConsecutiveOnes(int[] nums) {
    //     int count = 0, maxCount = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == 1) {
    //             count++;
    //         }else {
    //             count = 0;
    //         }
    //         maxCount = Math.max(maxCount, count);
    //     }
    //     return maxCount;
    // }

    //todo 方法 2 use two pinters
    // public int findMaxConsecutiveOnes(int[] nums) {
    //     int start = 0, end = 0, zeroCount = 0, res = 0;
    //     while (end < nums.length) {
    //         //if end meet 0
    //         if (nums[end] == 0) {
    //             zeroCount++;
    //             while (zeroCount != 0) {
    //                 if (nums[start++] == 0)
    //                  zeroCount--;
    //             }
    //         }
    //         res = Math.max(res, end - start + 1);
    //         end++;
    //     }
    //     return res;
    // }

    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0, count = 0;
        while (start < nums.length) {
            if (nums[start] == 1) {
                end = start + 1;
                for (;end < nums.length; end++) {
                    if (nums[end] != 1) break;
                }
                count = Math.max(count, end - start);
            }
            start++;
        }
        return count;
    }
//todo 第三种解法思考了好久 如何使用双指针
    //https://leetcode-cn.com/problems/max-consecutive-ones/solution/485-zui-da-lian-xu-1-de-ge-shu-shuang-zh-hv7p/
}
