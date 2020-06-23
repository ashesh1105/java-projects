package com.systemdesign.urlShortening;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 Simplest approach to generate unique ids could be to use java.util.UUID. Issue with that is it is a
 128 bit number, so takes more memory while caching it.

 Unique ID Generator. It user InetAddress class of Java to fetch System Time in Millis and appends to that the hash
 of Server IP to generate unique IDs.

 What if several requests for unique ids hit the server at the same time?
 The code below addresses that too where it uses sequence_number variable initialized with 0 and then increments itself
 by 1 every time requests arrive within same millisecond interval. For 1st request in next millisecond, sequence_number
 gets reset to 0 again and so on..

 Also notice that static variables are using and UniqueIdGenerator is a singleton class with getInstance static method
 available to grab its only instance. This ensures we do not keep on fetching System variables like InetAddress, etc.
 again and again since that is an expensive operation. If IP changes after a server restart (dynamic ip assignments),
 ipAddressHash will also gets reset (only once) after restart and clients keep on using it.

 */

public class UniqueIdGenerator {

    private static UniqueIdGenerator instance;

    // Get Server IP and Host Name
    private static InetAddress ip = null;
    private static String ipAddress = "";   // Info purpose only
    private static long ipAddressHash = 0;
    private static String hostName = "";    // Info purpose only
    private static int sequence_number = 0;
    private static long lastIdGeneratedAt = 0l;

    private UniqueIdGenerator() {
        try {
            // Get Server IP and Host Name
            ip = InetAddress.getLocalHost();
            ipAddress = ip.getHostAddress();
            hostName = ip.getHostName();
            ipAddressHash = ip.hashCode();
            lastIdGeneratedAt = System.currentTimeMillis();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static UniqueIdGenerator getInstance() {

        if (instance == null) {
            synchronized (UniqueIdGenerator.class) {
                if (instance == null) {
                    instance = new UniqueIdGenerator();
                }
            }
        }
        return instance;
    }

    public long getNextId() {

        long currentTimeMillis = System.currentTimeMillis();

        if (!(currentTimeMillis > lastIdGeneratedAt)) {
            sequence_number++;
        } else {
            sequence_number = 0;
        }

        long uniqueId = currentTimeMillis + ipAddressHash + sequence_number;

        lastIdGeneratedAt = currentTimeMillis;

        return uniqueId;
    }
}
