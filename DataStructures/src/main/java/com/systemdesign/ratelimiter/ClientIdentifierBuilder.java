package com.systemdesign.ratelimiter;

import java.util.Random;

public class ClientIdentifierBuilder implements ClientIdentifier {

    // This method will return bucketIdentifier for a service request based on context
    // which allows the RateLimiter to find the TokenBucket from RulesCache
    // To simulate, we are doing it similar to RulesService simulation, so keys match
    @Override
    public String getBucketIdentifierFromContext() {

        Random random = new Random();

        return "key" + random.nextInt(3);   // returns key0, key1 or key2 randomly
    }
}
