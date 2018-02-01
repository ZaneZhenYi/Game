package cn.zzgame.test;

import java.util.HashMap;

public class Test {
	
	static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();  
        long startTime = System.currentTimeMillis();  
        for (int i = 0; i < 1000000; i++) {  
            map.put(i, "a");  
        }  
        long endTime = System.currentTimeMillis();  
        System.out.println(endTime - startTime);  
        System.out.println("---------------");  
        HashMap<Integer, String> map2 = new HashMap<Integer, String>(1000000, 0.6f);  
        startTime = System.currentTimeMillis();  
        for (int i = 0; i < 1000000; i++) {  
            map2.put(i, "a");  
        }  
        endTime = System.currentTimeMillis();  
        System.out.println(endTime - startTime);  
        
        System.out.println(tableSizeFor(1000000));
	}
	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
}
