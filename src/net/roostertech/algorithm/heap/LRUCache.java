package net.roostertech.algorithm.heap;

import junit.framework.Assert;
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



    @Test
    public void testLRU() {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);
        cache.set(5, 12);
        Assert.assertEquals(12, cache.get(5));//        returns 12
        Assert.assertEquals(10, cache.get(1));//        returns 10
        Assert.assertEquals(-1, cache.get(10));//       returns -1
        cache.set(6, 14);//    this pushes out key = 5 as LRU is full.
        Assert.assertEquals(-1, cache.get(5));
    }


    //    6 2  S 2 1   S 1 1   S 2 3   S 4 1  G 1 G 2
    @Test
    public void testLRU2() {
        LRUCache cache = new LRUCache(2);

        cache.set(2, 2);
        cache.set(1, 1);
        cache.set(2, 3);
        cache.set(4, 1);

        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(2));

    }


    //59 7 S 2 1  S 1 10  S 8 13  G 12   S 2 8    G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8
    @Test
    public void testLRU3() {
        LRUCache cache = new LRUCache(7);
        //59 7 S 2 1  S 1 10  S 8 13  G 12
        cache.set(2, 1);
        cache.set(1, 10);
        cache.set(8, 13);
        System.out.println(cache.get(12));

        // S 2 8  G 11 G 7 S 14 7 S 12 9
        cache.set(2, 8);
        System.out.println(cache.get(11));
        System.out.println(cache.get(17));
        cache.set(14, 7);
        cache.set(12, 19);

        // S 7 10 G 11 S 9 3 S 14 15 G 15 G 9
        cache.set(7, 10);
        System.out.println(cache.get(11));
        cache.set(9, 3);
        cache.set(14, 15);
        System.out.println(cache.get(15));
        System.out.println(cache.get(9));

        // S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13
        cache.set(4, 13);
        System.out.println(cache.get(3));
        cache.set(13, 7);
        System.out.println(cache.get(2));
        cache.set(5, 9);
        System.out.println(cache.get(6));
        System.out.println(cache.get(13));


        // S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7
        cache.set(4, 5);
        cache.set(3, 2);
        cache.set(4, 12);
        System.out.println(cache.get(13));
        System.out.println(cache.get(7));
        cache.set(9, 7);



        // G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8
//
//        Assert.assertEquals(-1, cache.get(1));
//        Assert.assertEquals(3, cache.get(2));

    }
}
