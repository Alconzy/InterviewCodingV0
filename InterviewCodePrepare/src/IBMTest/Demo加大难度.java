package IBMTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo加大难度 {
    //"1111222334"
    public static String operate(String input, int K) {
        if (input == null || input.length() == 0)
            return input;
        List<Character> list = new ArrayList<>();
        for (char s : input.toCharArray()) {
            list.add(s);
        }
        while(K-- != 0) {
            char first = list.get(0);
            int firstCount = 0;
            while (list.get(0) == first) {
                list.remove(0);
                firstCount++;
            }
            while(firstCount != 0) {
                list.add(first);
                firstCount--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character element : list) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(operate("1111222334", 10));
    }
}
