package Leetcode.Easy200.array;

public class L977 {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) return nums;
        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }

        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1, i = end;
        //todo 曾犯错 while(start < end && ...)
        //todo 为什么一定从尾部开始 因为原数组单调递增  哪怕有可能左边有负数 也一定满足 最大值一定在最左 或 最右 不能在中间
        while(start <= end && i < nums.length) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                res[i--] = nums[start] * nums[start];
                start++;
            }else {
                res[i--] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}
