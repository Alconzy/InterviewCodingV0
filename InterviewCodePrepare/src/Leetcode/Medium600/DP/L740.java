package Leetcode.Medium600.DP;

public class L740 {
    //todo https://leetcode.com/problems/delete-and-earn/
    // 参考 https://leetcode-cn.com/problems/delete-and-earn/solution/gong-shui-san-xie-zhuan-huan-wei-xu-lie-6c9t0/
    int[] arr = new int[10009];
    //if choose remove and accumulate current i-th, then you must also delete (without adding to sum) arr[i-1th] and arr[i+1th]
    public int deleteAndEarn(int[] nums) {
        //store the key-value in array
        //key: index, refers to the element
        //value: how many times it occurs
        //max means how many numbers  in dp[], which means size of dp
        int max = 0;
        for (int element : nums) {
            arr[element]++;
            max = Math.max(element, max);
        }
        //dp[element][0] means choose, dp[element][1] means not choose
        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * arr[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][1], f[max][0]);
    }
}
