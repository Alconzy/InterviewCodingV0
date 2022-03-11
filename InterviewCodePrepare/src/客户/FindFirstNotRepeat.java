package 客户;

import java.util.HashMap;

public class FindFirstNotRepeat {
    public static Character find(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char element : str.toCharArray()) {
            hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        System.out.println(find(str));

    }
}
