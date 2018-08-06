//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4


import java.util.LinkedHashMap;
import java.util.Map;




//https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html
//https://www.cnblogs.com/lzrabbit/p/3734850.html
//https://blog.csdn.net/foye12/article/details/78647647

public class LRUcache146 {
    //use LinkedHashMap
    Map<Integer , Integer> dict;
    int capacity;

    public LRUcache146(int capacity) {
        this.capacity=capacity;
        int size=  (int) (capacity/0.75)+1;
        this.dict=new LinkedHashMap(size , 0.75f , true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size()>capacity;
            }
        };
    }

    public int get(int key) {
        return this.dict.get(key);
    }

    public void put(int key, int value) {
        this.dict.put(key , value);
    }
}
