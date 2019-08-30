package java_think;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * 测试WeakReference
 */
public class TestWeakReference {
    public static void main(String[] args) {
        testWeakHashMap();
    }

    private static void testWeakHashMap() {
        WeakHashMap<Data, Data> weakHashMap = new WeakHashMap<>();
        Data dataValue1 = new Data(102,2);
        Data dataValue2 = new Data(203, 1);

        weakHashMap.put(new Data(102, 2), (new WeakReference<Data>(dataValue1).get()));
        weakHashMap.put(new Data(103, 2), dataValue2);

        System.gc();
        Set<Map.Entry<Data, Data>> entrySet = weakHashMap.entrySet();
        System.out.println(entrySet.size());
        System.out.println(dataValue1.value);
        System.out.println(dataValue2.value);
    }

    private static void testWeakReference() {
        //        Data data = new Data(101, 1);
        ReferenceQueue<Data> referenceQueue = new ReferenceQueue<Data>();
        WeakReference<Data> weakReference = new WeakReference<>(new Data(101, 1),
                referenceQueue);
        System.gc();
        if (weakReference.get() != null) {
            System.out.println("[key]:    " + weakReference.get().key);
            System.out.println("[value]:    " + weakReference.get().value);
        }


        Reference<Data> dataReference = null;
        while ((dataReference = (Reference<Data>) referenceQueue.poll()) != null) {
            Data temp = dataReference.get();
            System.out.println(temp == null);
        }
        referenceQueue.poll();
    }

    static class Data {
        int value;
        int key;

        Data(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }
}
