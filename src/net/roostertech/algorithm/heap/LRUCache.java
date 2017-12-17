package net.roostertech.algorithm.heap;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by pnguyen on 12/16/17.
 */
public class LRUCache {
    private Map<Integer, Integer> kv = new HashMap<>();
    private LinkedList<Integer> lru = new LinkedList<>();
    private int capacity = 1;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (kv.containsKey(key)) {
            lru.remove(lru.indexOf(key));
            lru.add(key);
            return kv.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (kv.containsKey(key)) {
            lru.remove(lru.indexOf(key));
            lru.add(key);
        } else {
            lru.add(key);
            if (lru.size() > capacity) {
                int oldKey = lru.remove();
                kv.remove(oldKey);
            }
        }
        kv.put(key, value);

        System.out.println(lru);
        System.out.println(kv);

    }

}
