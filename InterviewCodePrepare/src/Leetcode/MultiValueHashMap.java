package Leetcode;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MultiValueHashMap<K, V> {
    HashMap<K, List<V>> data;

    private K key;
    private List<V> values;

    public MultiValueHashMap() {
        this.data = new HashMap<>();
    }

    public V put(K key, V value) {

       if (!data.containsKey(key) || !data.get(key).contains(value)) {
           List<V> values = new ArrayList<>();
           values.add(value);
           data.put(key, values);
       }
       return value;
    }

//    public List<V> getValues(K key) {
//        if (data.get())
//    }

    public static void checkElement(List<String> input) {
        System.out.println(input);
    }

    public static void main(String[] args) {
        MultiValueHashMap<String, Integer> multiValueHashMap = new MultiValueHashMap<>();
        multiValueHashMap.put("Alan", 12);
        MultiValueHashMap.checkElement(new LinkedList<>(List.of("abc", "efg")));

    }
}
