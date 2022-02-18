package Leetcode.Medium600;

public class Leetcode402 {
    public static void main(String[] args) {
        /**
         * 1.
         * todo 罗列各种转换String or Character to Integer 的方式
         * Character.getNumericValue(char element);
         *
         * Integer.valueOf(String str): return a Integer object;
         *
         * Integer.parseInt(String str): return primitive int value;
         *
         *
         * 2. todo
         *      一开始思路想要把character 转化为 int 才能方便比较，但是没有意识到 char 可以直接比较，
         *      原因，ASCII 中 '3' < '4' < '5' < ..... '1009' < ....
         *
         *
         * 3. todo
         *     获取数字int/integer/long长度
         *      https://cloud.tencent.com/developer/ask/35861
         *
         *  git基于对数的解决方案，不计算非常大的长整数的字数，例如：
         *  long n = 99999999999999999L;
         *
         * // correct answer: 17
         * int numberOfDigits = String.valueOf(n).length();
         *
         * // incorrect answer: 18
         * int wrongNumberOfDigits = (int) (Math.log10(n) + 1);
         *
         *              ---------------或者--------------
         * final int digits = number==0?1:(1 + (int)Math.floor(Math.log10(Math.abs(number))));
         *
         *
         * 4.todo
         *      git 使用问题
         *      曾经一直 git checkout branch 都是 origin/main 具体看链接
         *
         *      问题解释：（什么是origin/main 什么是 remotes/origin/master 什么是 master)
         *          https://stackoverflow.com/questions/10588291/git-branching-master-vs-origin-master-vs-remotes-origin-master
         *      解决：
         *          https://stackoverflow.com/questions/5989592/git-cannot-checkout-branch-error-pathspec-did-not-match-any-files-kn
         */

    }
}
