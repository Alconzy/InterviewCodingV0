import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 常错Java语法 {

public static void main(String[] args) {
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
        if (s.equals("love")) {
            it.remove();
        }
    }

    System.out.println(list1);
}

}
