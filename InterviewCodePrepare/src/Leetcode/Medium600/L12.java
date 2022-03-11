package Leetcode.Medium600;

public class L12 {
    String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC","L","XL", "X", "IX", "V", "IV", "I"};
    int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roman.length && num > 0; i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
