package com.systemdesign.ratelimiter;

public interface RateLimiter {

    boolean allowRequest(int tokensRequired);

}
