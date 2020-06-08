package com.systemdesign.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RetrieveJobScheduler implements JobScheduler {

    private ExecutorService pool = Executors.newFixedThreadPool(3);

    // Start scheduler
    public void start(int numTasks) {

        System.out.println("Starting Job Scheduler with " + numTasks + " tasks..");
        for (int i=0; i<numTasks; i++) {
            pool.submit(new RetrieveRulesTask());
        }
    }

    // Stop scheduler, allowing existing jobs to finish
    public void stop(int timeoutSecs) {
        pool.shutdown();

        try {
            pool.awaitTermination(timeoutSecs, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}
