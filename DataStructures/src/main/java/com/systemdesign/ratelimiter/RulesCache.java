package com.systemdesign.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface RulesCache {

    static Map<String, TokenBucket> bucketCache = new ConcurrentHashMap<>();

    static TokenBucket getTokenBucket(String bucketIdentifier) {
        return bucketCache.get(bucketIdentifier);
    }

    static void addTokenBucket(String bucketIdentifier, TokenBucket tokenBucket) {
        bucketCache.put(bucketIdentifier, tokenBucket);
    }

}
