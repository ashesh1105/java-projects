package com.systemdesign.ratelimiter;

public class TokenBucketRateLimiter implements RateLimiter {

    ClientIdentifier clientIdentifier = null;

    public TokenBucketRateLimiter() {
        clientIdentifier = new ClientIdentifierBuilder();
    }

    @Override
    public boolean allowRequest(int tokensRequired) {

        String bucketIdentifier = clientIdentifier.getBucketIdentifierFromContext();
        TokenBucket tokenBucket = RulesCache.getTokenBucket(bucketIdentifier);

        if (tokenBucket == null) {
            System.out.println("TokenBucket for this request not available in cache, can't allow this request!");
            return false;
        }

        boolean result = tokenBucket.allowRequest(tokensRequired);

        // Log the result
        System.out.println("The request for " + bucketIdentifier + " was " + (result ? "allowed." : "not allowed."));

        return result;
    }
}
