package Leetcode.Easy200.array;

public class L27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int slow = 0;
        //todo 曾犯错
        //  for (int fast = 0; fast < nums.length; fast++) {
        // .... nums[slow++] = nums[fast];
        //错因： while 结束之后不应该再++
        for (int fast = 0; fast < nums.length;) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast++];
            }
            while (fast < nums.length && nums[fast] == val) {
                fast++;
            }
        }
        return slow;
    }
}
