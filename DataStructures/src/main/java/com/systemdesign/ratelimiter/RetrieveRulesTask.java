package com.systemdesign.ratelimiter;

public class RetrieveRulesTask implements Runnable {

    @Override
    public void run() {

        // Makes a call to Rules Service to retrieve:
        // 1) bucketIdentifier (say, API Key or login / IP info for an incoming request,
        // 2) maxBucketSize and 3) refillRate for above identifier, so TokenBucket can be created
        // For this design, we are simulating this call
        int maxBucketSize = RulesService.getMaxBucketSize();  // this will come from Rules Service
        int refillRate = RulesService.getRefillRate();  // this will come from Rules Service
        String bucketIdentifier = RulesService.getBucketIdentifier();

        TokenBucket tokenBucket = new TokenBucket(maxBucketSize, refillRate);

        System.out.println("Updating RulesCache for bucketIdentifier " + bucketIdentifier);
        RulesCache.addTokenBucket(bucketIdentifier, tokenBucket);
        System.out.println("Done updating " + bucketIdentifier);
    }
}
