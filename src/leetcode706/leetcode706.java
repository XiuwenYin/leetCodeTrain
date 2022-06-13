package leetcode706;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.hash;

public class leetcode706 {

}

class MyHashMap {
    private class Pair{
        private int key;
        private int value;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    private static final int BASE = 769;
    private LinkedList[] data;
    
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Pair>();
        }

    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if(pair.getKey() == key) {
                pair.value = value;
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if(pair.getKey() == key) {
                return pair.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while(iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.key == key) {
                data[h].remove(pair);
                return;
            }
        }
    }
    public static int hash(int key) {
        return key % BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
