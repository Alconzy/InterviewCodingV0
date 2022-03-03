package Hackerrank;
import java.io.*;
import java.util.*;

public class JavaList {
    //https://www.hackerrank.com/challenges/java-list/problem?isFullScreen=true
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        //read input
        System.out.println("please give size of input array");
        Scanner scan = new Scanner(System.in);
        System.out.println("please give input array");
        int arrSize = scan.nextInt();
        //use linkedlist for frequently add or delete
        List<Integer> list = new ArrayList<>();
        //scan.nextLine();//why shoud not use
        for (int i = 0; i < arrSize; i++) {
            list.add(scan.nextInt());
        }
        //scan.nextLine();//why not use
      //  scan.nextLine();
        int operationCount = scan.nextInt();
        for(int i = 0; i < operationCount; i++) {
            String nextLine = scan.nextLine();
            System.out.println(nextLine);
            if (scan.nextLine().equals("Insert")){
                int nextIdx = scan.nextInt();
                int nextValue = scan.nextInt();
                list.add(nextIdx, nextValue);
            }else {
                int nextInt = scan.nextInt();
                //notice: remove(atIndex)
                //if want remove say, Integer 2, do below:
                //list.remove(new Integer(2));
                list.remove(nextInt);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
