package Leetcode.Easy200;

import java.util.LinkedList;

public class Valid括号20 {
    public boolean isValid(String s) {
        //use stack
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.offerLast(')');
            else if (c == '[')
                stack.offerLast(']');
            else if (c == '{')
                stack.offerLast('}');
            else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
