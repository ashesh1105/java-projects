package com.multithreading.synchronizers.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CyclicBarrier is similar to CountDownLatch which we have seen in the last article  What is CountDownLatch in Java
 * and allows multiple threads to wait for each other (barrier) before proceeding. The difference between CountDownLatch
 * and CyclicBarrier is an also very popular multi-threading interview question in Java. CyclicBarrier is a natural
 * requirement for a concurrent program because it can be used to perform the final part of the task once individual
 * tasks are completed.
 *
 * All threads which wait for each other to reach barrier are called parties, CyclicBarrier is initialized with a number
 * of parties to wait and threads wait for each other by calling CyclicBarrier.await() method which is a blocking
 * method in Java and blocks until all Thread or parties call await().
 *
 * In general calling await() is shout out that Thread is waiting on the barrier. await() is a blocking call but can be
 * timed out or Interrupted by other threads. Read more at:
 * https://javarevisited.blogspot.com/2012/07/cyclicbarrier-example-java-5-concurrency-tutorial.html#ixzz6RLLvA91D
 */

public class CyclicBarrierDemo {

    //Runnable task for each thread
    private static class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {

        //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });

        //starting each of thread
        Thread t1 = new Thread(new Task(cb), "Thread 1");
        Thread t2 = new Thread(new Task(cb), "Thread 2");
        Thread t3 = new Thread(new Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();

    }
}
