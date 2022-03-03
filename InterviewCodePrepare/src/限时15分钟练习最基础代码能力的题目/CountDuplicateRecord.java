package 限时15分钟练习最基础代码能力的题目;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountDuplicateRecord {
    //assume number of all list is 5
    public static int countDuplicateRecord(List<String> prod, List<Integer> price, List<Integer> weight) {
        HashSet<Record> records = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            records.add(new Record(prod.get(i), price.get(i), weight.get(i)));
        }

        return 5 - records.size();
    }


    public static void main(String[] args) {
        List<Record> records = new ArrayList<>();

        //todo list.of() 生成的list不能有null!!!! 看document @Notnull
        // moreover https://stackoverflow.com/questions/11992694/how-to-determine-if-a-list-of-string-contains-null-or-empty-elements
        /**
         * The problem with this solution is that List.contains is allowed to throw NullPointerException if the list is not allowed to contain null. For example: List.of("foo", "bar").contains(null) will throw! –
         * James Marble
         *  May 13, 2020 at 23:40
         */
        List<String> prod = List.of("Alan", "Cozy", "Alan", "Alan", "Alan");
        List<Integer> price = List.of(1,1,2,1,1);
        List<Integer> weight = List.of(1,1,2,1,1);

        System.out.println(countDuplicateRecord(prod, price, weight));
    }

}
class Record {
    String prod;
    Integer price;
    Integer weight;

    public Record(String prod, Integer price, Integer weight) {
        this.prod = prod;
        this.price = price;
        this.weight = weight;
    }

    /**
     * todo 不明白为什么要同时hashcode 和 equals 复写， 为什么不能只是其一！！！！！
     * @return
     */
    @Override
    public int hashCode() {
        return this.price.hashCode() + this.price + this.weight;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;

        //todo 注意!!!
        // Check if o is an instance of Complex or not
        // null instanceof [type]" also returns false
        if (!(other instanceof Record)) {
            return false;
        }

        Record otherObj = (Record) other;
        return otherObj.prod.equals(this.prod) && otherObj.price == this.price && otherObj.weight == this.weight;
    }
}