package Leetcode.Medium600.String;

public class L151 {
    public String reverseWords(String s) {
        //reverse each and then reverse whole

        char[] arr = s.toCharArray();
        //delete spaces
        int start = 0;
        for (int end = 0; end < arr.length; end++){
            if (arr[end] == ' ' && (end == 0  || arr[end - 1] == ' '))
                continue;
            arr[start++] = arr[end];
        }
        if (start > 0 && arr[start - 1] == ' ')
            start--;
        String str =  new String(arr, 0, start);

        arr = str.toCharArray();
        int slow = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                reverse(arr, slow, i - 1);
                slow = i + 1;
            }
        }
        reverse(arr, 0, arr.length - 1);

        return new String(arr);
    }

    //reverse
    public void reverse(char[] arr, int start, int end) {
        if (arr == null || arr.length == 0)
            return;
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
