package src.java_think;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class TestHashMap {
    public static void main(String[] args) {
//        testLinkedHashMapAccessOrder();
        testHashMapHashCode();
    }

    /**
     * linkedHashMap,如果accessOrder=true,那么每次访问节点后,就会将节点放置在链表的末尾.
     */
    private static void testLinkedHashMapAccessOrder() {
        HashMap<String, String> hashMap = new HashMap<>();
        LinkedHashMap<String, String> linkedHashMap =
                new LinkedHashMap<String, String>(3, 0.75f, true);

        linkedHashMap.put("zhaoyang", "zhaoyang");
        linkedHashMap.put("lishuoyan", "lishuoyan");
        linkedHashMap.put("changxing", "changxing");

        linkedHashMap.get("lishuoyan");
        linkedHashMap.get("zhaoyang");
        linkedHashMap.get("changxing");

        Iterator<String> iterator =
                linkedHashMap.values().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void testHashMapHashCode() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("zhaoyang", 26);
    }
}
