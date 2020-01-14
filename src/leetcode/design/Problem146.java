package src.leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * LRU缓存机制
 *运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 * 解题思路:
 * 用hashMap保存entry数据,同时用linkedlist保存entry的访问顺序.
 *
 * */
public class Problem146 {
    static class LRUCache {
        private HashMap<Integer, Integer> insertionMap;
        private LinkedList<Integer> accessList;
        private int maxSize;

        public LRUCache(int capacity) {
            insertionMap = new HashMap<>(capacity);
            accessList = new LinkedList<>();
            maxSize = capacity;
        }

        /**
         * @param key 如果能获取key,则返回key对应的value,并且将key移动到accessList末尾
         *            获取不到key,则返回-1
         */
        public int get(int key) {
            if (insertionMap.size() <= 0)
                return -1;

            Integer keyObject = (Integer) key;
            if (!insertionMap.containsKey(keyObject)) {
                return -1;
            } else {
                Integer value = insertionMap.get(keyObject);
                accessList.remove(keyObject);
                accessList.addLast(keyObject);
                return value;
            }
        }

        public void put(int key, int value) {
            Integer keyObject = (Integer)key;

            if (insertionMap.containsKey(keyObject)) {
                insertionMap.put(keyObject, value);
                accessList.remove(keyObject);
            } else {
                //如果插入新元素时,map的大小已经超过上限,则从访问队列中取出头部元素并在insertionMap中删除.
                if (insertionMap.size() >= maxSize) {
                    Integer keyRemoved = accessList.pollFirst();
                    insertionMap.remove(keyRemoved);
                }

                insertionMap.put(keyObject, value);
            }
            accessList.addLast(keyObject);
        }
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
