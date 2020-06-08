package com.systemdesign.ratelimiter;

/**
 Application Flow:
 1) JobScheduler is used to start the scheduler. It has a thread pool which spawns desired number of RetrieveRulesTask.
 2) RetrieveRulesTask calls RulesService to receive unique identifiers for requests and associated rules related to
    maxBucketSize and refillRate allowed for a request type (bucket). RetrieveRulesTask creates TokenBucket and adds
    that to RulesCache based on these info.
 3) JobScheduler can be started and stopped based on desired frequency, say, every 5, 10, 30 minutes, so RulesCache
    stay populated with all request types based on incoming requests (API Keys issues, login / IP combination, etc.)
 4) Client then calls allowRequest on RateLimiter, if response is true, request proceeds, else, throttle it.
    In case of false, we can also send the request to a messaging queue (like Kafka) to process it later on.
 5) RateLimiter get bucketIdentifier from ClientIdentifier, which generated keys in same way that is used by Rules Service
    -> RetrieveRulesTask while adding the TokenBucket to RulesCache, else keys won't match. So the scheme to identify
    a type of request (bucket) needs to be consistent, say, API Keys, userId / IP combination, etc.
 6) RateLimiter retrieves the TokenBucket for a service request from RulesCache and calls allowRequest on that bucket.
 */

public class Client {

    public static void main(String[] args) {

        // Client won't have to call this in actual set up, it will be called as timer process from somewhere else.
        // We can also have while(true) loop with tasks doing the job and then sleeping for sometime.
        // Here, we are doing it for simplicity
        JobScheduler scheduler = new RetrieveJobScheduler();
        scheduler.start(3);
        scheduler.stop(5);

        // Sleep for sometime so caches get populated
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RateLimiter rateLimiter = new TokenBucketRateLimiter();
        boolean allowed;

        // Simulating incoming service requests and RateLimiter checks made on them
        for(int i=0; i<20; i++) {

            if (rateLimiter.allowRequest(2)) {
                // Proceed to serving this request
            } else {
                // Throttle this request or send it to a messaging queue, to be served later on
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
