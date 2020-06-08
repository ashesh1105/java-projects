package com.systemdesign.ratelimiter;

// This will help us simulate Rules Service we will have in actual set up
public class RulesService {

    // Will not need it in actual set up. This is to help RetrieveRulesTask get the identifier
    // In actual set up RetrieveRulesTask will get it from Rules Service
    private static int i = 0;

    // To help RetrieveRulesTask get bucketIdentifier since Rules Service is not there.
    public static String getBucketIdentifier() {
        return "key" + i++;
    }

    // To help RetrieveRulesTask get maxBucketSize for a bucket since Rules Service is not there.
    public static int getMaxBucketSize() {
        return 4;
    }

    // To help RetrieveRulesTask get refillRate for a bucket since Rules Service is not there.
    public static int getRefillRate() {
        return 4;
    }
}
