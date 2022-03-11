package 限时15分钟练习最基础代码能力的题目.不超10分钟;

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class L26 {
    public int removeDuplicates(int[] nums) {
        //todo 原本
        /**
         *  if (nums == null) {
         *             return 0;
         *         }
         *         if (nums.length <= 1)
         *             return nums.length;
         *
         *             但是可以化简！！！！
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //two pointers
        //[0,slow] valid
        //[fast, end] need to explore
        //(slow, fast) do not care
        int slow = 0;
        for (int fast = 1; fast < nums.length;) {
            //fast meet no duplicate
            if (nums[fast] != nums[fast - 1]) {
                //swap
                nums[++slow] = nums[fast];
                fast++;
            }else {
                while (fast < nums.length && nums[fast] == nums[fast - 1])
                    fast++;
            }
        }
        return slow + 1;
    }
}
