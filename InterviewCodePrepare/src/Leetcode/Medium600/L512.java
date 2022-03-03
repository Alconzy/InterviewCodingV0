package Leetcode.Medium600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题解1 DFS 暴力：
 *  含图， 便于理解：
 *      暴力图解 https://blog.csdn.net/Julse/article/details/119747331
 *      https://leetcode-cn.com/problems/beautiful-arrangement/solution/dong-tai-gui-hua-dao-di-shi-ge-sha-by-mu-shil/
 *
 *
 */
public class L512 {
    public static List<List<Integer>> solution(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buf = new ArrayList<>();
        for (int i = 1; i <= n; i++) buf.add(i);
        if (n <= 0) {
            return result;
        }
        helper(result, buf, 0);
        return result;
    }
    public static void helper(List<List<Integer>> result, List<Integer> buf, int index) {
        if (index == buf.size()) {
            for (int i = 0; i < buf.size(); i++) {
                if (buf.get(i) % (i + 1) != 0 && (i + 1) % buf.get(i) != 0)
                    return;
            }
            result.add(new ArrayList<Integer>(buf));
            return;
        }
        //i refer to the idx of first element that need to swap
        for (int i = index; i < buf.size(); i++) {
            //swap buf[i] and buf[index]
            Collections.swap(buf, i, index);
            helper(result, buf, index+1);
            //when reach this line, it start backtracking, then we need to 恢复原来的状态，相当于吃吐的吐
            Collections.swap(buf, i, index);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
