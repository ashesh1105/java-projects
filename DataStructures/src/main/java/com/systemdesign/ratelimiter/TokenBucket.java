package com.systemdesign.ratelimiter;

/**
 This class allows creating a bucket with given maxBucketSize and refillRate at which we want to allow new tokens to
 be accumulated in the bucket. The allowRequest is the only API it exposes which is synchronized and it returns
 true of false based on if enough token available in the bucket for a service to continue or not.

 This algorithm can be used to decide whether to allow a service to continue or throttle it. Helps on RateLimiting apps.
 */

public class TokenBucket {

    private int currentBucketSize;
    private int maxBucketSize;
    private long lastRefillTimestamp;   // System.nanoTime()
    private int refillRate; // token per sec

    public TokenBucket(int maxBucketSize, int refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.currentBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens) {

        refill();

        if (currentBucketSize >= tokens) {
            currentBucketSize -= tokens;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        currentBucketSize += (now - lastRefillTimestamp) * refillRate / 1e9;
        currentBucketSize = Math.min(currentBucketSize, maxBucketSize);
        lastRefillTimestamp = now;
    }

    // Test above
    public static void main(String[] args) {

        // Warning! Below code will run 2 threads in infinite loop. Manual stop of this program will be required!

        TokenBucket bucket1= new TokenBucket(4, 2);
        TokenBucket bucket2= new TokenBucket(4, 2);

        // Simulated for a service request to our system
        new Thread(() -> {

            long id = Thread.currentThread().getId();
            while(true) {
                boolean allowed = bucket1.allowRequest(3);
                if(allowed) {
                    System.out.println("Thread " + id + " with bucket1 was allowed to continue.");
                } else {
                    System.out.println("Thread " + id + " with bucket1 was not allowed to continue. Sleeping for 5 sec..");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // Simulated for 2nd service request to our system, using same bucket as previous one
        new Thread(() -> {

            long id = Thread.currentThread().getId();
            while(true) {
                boolean allowed = bucket1.allowRequest(3);
                if(allowed) {
                    System.out.println("Thread " + id + " with bucket1 was allowed to continue.");
                } else {
                    System.out.println("Thread " + id + " with bucket1 was not allowed to continue. Sleeping for 5 sec..");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // Simulated for 3rd service request to our system, using a different bucket
        new Thread(() -> {

            long id = Thread.currentThread().getId();
            while(true) {
                boolean allowed = bucket2.allowRequest(3);
                if(allowed) {
                    System.out.println("Thread " + id + " with bucket2 was allowed to continue.");
                } else {
                    System.out.println("Thread " + id + " with bucket2 was not allowed to continue. Sleeping for 5 sec..");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
