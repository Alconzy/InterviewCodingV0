package 限时15分钟练习最基础代码能力的题目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort the boxTypes
        List<int[]> list = new ArrayList<>();
        for (int[] element : boxTypes) {
            list.add(element);
        }

        //简单办法 Arrays.sort(boxTypes, (a, b) -> b - a);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int sum = 0;
        for (int i = 0; i < list.size() && truckSize != 0; i++) {
            int count = Math.min(list.get(i)[0], truckSize);
            sum += count * list.get(i)[1];
            truckSize -= count;
        }
        return sum;
    }
}
