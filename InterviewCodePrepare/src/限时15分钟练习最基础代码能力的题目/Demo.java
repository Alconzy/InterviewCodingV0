package 限时15分钟练习最基础代码能力的题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Operate K times of operations on a given array, return the final one
 * operations includes:
 *  1, let first element as E,
 *  2, remove all first E and append to tail
 *
 */
public class Demo {
    public static int[] operate(int N, int K, int[] arr) {
         if (arr == null || arr.length == 0)
             return arr;

        List<Integer> list = new ArrayList<>();
        for (int element : arr) {
            list.add(element);
        }

         while (K != 0) {
             int first = list.get(0);
             int count = 0;

             while (!list.isEmpty() && list.get(0) == first) {
                 count++;
                 list.remove(0);
             }

             while (count != 0) {
                 list.add(first);
                 count--;
             }
             K--;
         }
         for (int i = 0; i < arr.length; i++) {
             arr[i] = list.get(i);
         }
         return arr;
    }

    //方法2
    public static int[] operateII(int N, int K, int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;
        while (K-- != 0) {
            //two pointers
            int slow = 0, fast = 0, cur = arr[0];
            while (slow < arr.length)
                if  (fast < arr.length && arr[fast] == cur) fast++;
                else if (fast < arr.length)
                    arr[slow++] = arr[fast++];
                else
                    arr[slow++] = cur;
        }
        return arr;
    }


    public static void main(String[] args) {
//      Random random = new Random();

        //test 12 times
//      int testTimes = 12;
//        while (testTimes != 0) {
//            int size = random.nextInt(10);
//            int[] arr = new int[size];
//            for (int i = 0; i < size; i++) {
//                arr[i] = random.nextInt(10);
//            }
//            System.out.println("original: " + Arrays.toString(arr));
//            //first index is the length of the array
//            int operateTimes = random.nextInt(32);
//            System.out.println("operate times: " +  operateTimes);
//            int[] arr1 = new int[]{1,1,1,1,2,2,2,3,3,4};
//            System.out.println(Arrays.toString(operate(10,10,arr1)));
//            testTimes--;
//        }
        int[] arr1 = new int[]{1,1,1,1,2,2,2,3,3,4};
        int[] arr2 = new int[] {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(operateII(10,10,arr1))); //expect 3341111222
        System.out.println(Arrays.toString(operateII(10,9,arr2)));
    }
}
