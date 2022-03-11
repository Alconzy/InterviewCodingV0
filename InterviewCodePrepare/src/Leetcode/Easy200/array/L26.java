package Leetcode.Easy200.array;

public class L26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1)
            return nums.length;

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

    //todo 曾犯错
    //1 2 2 3 2
//    public int removeDuplicates(int[] nums) {
//        if(nums.length <= 1)
//            return nums.length;
//        int slow = 0;
//        for (int fast = 1; fast < nums.length;) {
//            if (nums[fast] != nums[fast - 1]) {
//                //todo 原错 nums[slow++] = nums[fast++]; 错例 [1,1,2] return [2], expect [1,2]
//                //所以因为这种情况 这题根 delete target element 处理不一样
//                //但是核心都是 [0， slow) 为valid
//                nums[++slow] = nums[fast++]；
//            }
//            while (fast < nums.length && nums[fast] == nums[fast-1]) {
//                fast++;
//            }
//        }
//        return slow;
//    }
}
