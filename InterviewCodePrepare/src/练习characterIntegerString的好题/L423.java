package 练习characterIntegerString的好题;

public class L423 {
    //参考 https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/solution/gong-shui-san-xie-nao-jin-ji-zhuan-wan-m-vg7a/

    //下code 参考https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/solution/gong-shui-san-xie-nao-jin-ji-zhuan-wan-m-vg7a/1246289
    public String originalDigits(String s) {
        //找到的规律告诉我们 排除顺序 0, 8, 6, 2, 3, 7, 5, 9, 4, 1
        //count the occurrence of each alphabet
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        int[] res = new int[10];
        for (int i = 0; i < 10; i++) {
            res[0] = alphabet['z' - 'a'];
            res[8] = alphabet['g' - 'a'];
            res[6] = alphabet['x' - 'a'];
            res[2] = alphabet['w' - 'a'];
            res[3] = alphabet['t' - 'a'] - res[8] - res[2];
            res[7] = alphabet['s' - 'a'] - res[6];
            res[5] = alphabet['v' - 'a'] - res[7];
            res[4] = alphabet['f' - 'a'] - res[5];
            res[1] = alphabet['o' - 'a'] - res[0] - res[2] - res[4];
            //todo 曾经犯错 res[9] = alphabet['n' - 'a'] - res[7] - res[1];
            //错例 “nnie" 输出了 99， 应该9。 因为nine有两个n!!!! 所以要不不除以2  要不用只有一个的
            res[9] = alphabet['i' - 'a'] - res[6] - res[5] - res[8];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
