import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 常忘刷题语法小技巧集合 {
    public static void main(String[] args) {
        /*********character string integer 大乱斗****/

        char[] arr = new char[] {'1','2','3','4'};
        System.out.println(String.valueOf(arr));


        String str = "12345";
        System.out.println(Integer.valueOf(str));
        System.out.println(Integer.parseInt(str));

        char c = '9';
        //expect int 9, same as expectation
        System.out.println(Integer.valueOf(c));
        char result = Character.valueOf(c);//todo this return a char, but also work for a int
        int intResult = Character.valueOf(c);
        System.out.println(result);
        System.out.println("expect 9 below but get:");
        System.out.println(intResult);
        int res = Character.getNumericValue(c);
        System.out.println("result as expected:");
        System.out.println(res);

        int charMinusChar = '5' - '0';//is a integer
        System.out.println("the result of '9'-'0' is: " + charMinusChar);

        int[] arr1 = new int['a' + 1];
        System.out.println(arr1['a']);

        int[] arr2 = new int[100];
        arr2['b' - 'a'] = 99;
        System.out.println(arr2[1]);



        /*******            **********/
        System.out.println("Cozy".substring(0, 2));

        //todo 启发自https://leetcode.com/problems/palindrome-permutation/solution/ 解法3
        int[] arr3 = new int[] {1,2,3};
      //  System.out.println(arr['a']);
        List<Integer> list = List.of(1,2,3);
        System.out.println(list.size());


        /*****  位运算 *****/
        System.out.println(" /*****  位运算 *****/");
        int k = 8;
        while (k != 0) {
            k >>= 1;
            System.out.println(k);
        }
        int k1 = 8;
        System.out.println(k1 & 1);



        /******  易错 ***/
        List<String> list1 = new ArrayList<>();
        list1.add("alan");
        list1.add("love");
        list1.add("love");
        list1.add("cozy");
        list1.add("love");
        list1.add("alan");

        //todo delete all love, 这种写法是错误的！！！ 原因看 https://github.com/Homiss/Java-interview-questions/blob/master/%E9%9B%86%E5%90%88/%E9%9B%86%E5%90%88%E7%9B%B8%E5%85%B3.md
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals("love")) {
                list1.remove(list1.get(i));
            }
        }

        //todo 改
        for (int i = list1.size() - 1; i >= 0 ; i--) {
            if (list1.get(i).equals("love")) {
                list1.remove(list1.get(i));
            }
        }

        //todo错误写法2 这种写法也是错的
        for (String element : list1) {
            if (element.equals("love")) {
                list1.remove(element);
            }
        }
        //todo 改

            Iterator<String> it = list1.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (s.equals("bb")) {
                    it.remove();
                }
            }

        /*** leetcode 151 */
    }

}
