package 限时15分钟练习最基础代码能力的题目;

public class Laicode281RemoveSpaces {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0)
            return input;
        char[] arr = input.toCharArray();
        //注意[0, a)是valid
        int slow = 0;

        for (int i = 0; i < arr.length; i++) {
            //合并 case 1 and case 2 因为 ("_" 表space)
            //case 1["_ _ _ _ _"]
            //case 2["a _ _ _ _"]
            //当case 2 时 要保留一个space "a _"
            //往后就一直走， 所以可以合并case 1 as below:
            if (arr[i] == ' ' && (i == 0 || arr[i - 1] == ' ') ) {
                continue;
            }
            arr[slow++] = arr[i];
        }

        //处理tail space
        //case 1 "_ _ _ a _" [0, slow] 后面do not care
        //case 2 "_ _ _ a" [0, slow] 后面do not care

        if (slow > 0 && arr[slow - 1] == ' ')// "a _ _" 因为 这种符合 a_b //注意[0, a)是valid
            slow--;
        return new String(arr, 0, slow);

    }
}
