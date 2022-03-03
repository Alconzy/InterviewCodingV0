package Leetcode.Medium600;

public class L5 {
    /**
     * todo
     *  多次犯错 String.length()!!!!
     *  String.subString() !!!! 应该是 String.substring()
     */
    //https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/
    //参考 https://labuladong.gitee.io/algo/4/32/137/
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null)
            return "";
        for (int pivot = 0; pivot < s.length(); pivot++) {
            String first = helper(s, pivot, pivot);
            String second = helper(s, pivot, pivot + 1);
            res = res.length() > first.length()? res: first;
            res = first.length() >  second.length()? first : second;
        }
        return res;
    }

    public String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
