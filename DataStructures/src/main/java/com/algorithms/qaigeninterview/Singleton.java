package com.algorithms.qaigeninterview;
//Is this singleton class thread safe? Why? If not, how can it be made it thread safe?
public class Singleton {

    private static Singleton instance;
    
    public final long state;

    private Singleton(long state) {
        this.state = state;
    }

    public static Singleton getInstance() {
    
        if (instance == null) {
        	
        	synchronized (Singleton.class) {
        		instance = new Singleton(System.currentTimeMillis());
        	}
            
        }
        return instance;
    }
}

//enum Enum {
//	
//	INSTANCE;
//	
//	// Any methods go here
//	
//}
