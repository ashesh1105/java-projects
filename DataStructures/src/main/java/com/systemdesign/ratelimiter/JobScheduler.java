package com.systemdesign.ratelimiter;

public interface JobScheduler {

    void start(int numTasks);
    void stop(int timeout);

}
