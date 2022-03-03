package 限时15分钟练习最基础代码能力的题目;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class addStringNumbers {
    public static int add(String num1, String num2) {
       int i = num1.length() - 1, j = num2.length() - 1, overflow = 0;
        List<Integer> res = new ArrayList<>();
       while (i >= 0 && j >= 0) {
           int digit = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + overflow;

           overflow = digit / 10;
           res.add(0, digit % 10);
           i--;
           j--;
       }

       while (i >= 0) {
           int digit = Character.getNumericValue(num1.charAt(i)) + overflow;
           overflow = digit / 10;
           res.add(0, digit % 10);
           i--;
       }

        while (j >= 0) {
            int digit = Character.getNumericValue(num1.charAt(j)) + overflow;
            overflow = digit / 10;
            res.add(0, digit % 10);
            j--;
        }

        if (overflow != 0) {
            res.add(0, 1);
        }

        int sum = 0;
        for (int a = 0, b = res.size() - 1; a < res.size(); a++, b--) {
            sum += res.get(a) * Math.pow(10, b);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add("999", "1"));
    }
}
