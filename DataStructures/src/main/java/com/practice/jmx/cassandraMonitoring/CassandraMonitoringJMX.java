package com.practice.jmx.cassandraMonitoring;

import org.apache.cassandra.metrics.CassandraMetricsRegistry;
import org.apache.commons.lang3.StringUtils;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CassandraMonitoringJMX {

    public static void main(String[] args) throws Exception {

        String nodes = "localhost:9142";

//        String host = "127.0.0.1";
        String host = "";
        for(String node : nodes.split(",")) {
            host = node.split(":")[0];
        }
        String jmxPort = "7199";
        String jmxUrl = "service:jmx:rmi:///jndi/rmi://" + host + ":" + jmxPort + "/jmxrmi";

        JMXServiceURL url = new JMXServiceURL(jmxUrl);

//        String [] credentials = new String[2];
//        credentials[0] = "jmx_read_user";
//        credentials[1] = "tCzyTdRh8w";
//        Map<String, String[]> environment = new HashMap<>();
//        environment.put(JMXConnector.CREDENTIALS, credentials);

        JMXConnector jmxc = JMXConnectorFactory.connect(url, null); // use environment for authentication

        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        Map<String, Set<ObjectInstance>> metricMap = new HashMap<>();

        Set<ObjectInstance> objClientRequestMetricsReadFailures = mbsc.queryMBeans(ObjectName
                .getInstance("org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=*"), null);

        metricMap.put("ClientRequest Metrics: Read Failures", objClientRequestMetricsReadFailures);

//        Set<ObjectInstance> objClientRequestMetricsReadLatency = mbsc.queryMBeans(ObjectName
//                .getInstance("org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=Latency"), null);
//
//        metricMap.put("ClientRequest Metrics: Read Latency", objClientRequestMetricsReadLatency);

//        Set<ObjectInstance> objStorageMetrics = mbsc.queryMBeans(ObjectName
//                .getInstance("org.apache.cassandra.metrics:type=Storage,name=Load"), null);
//
//        metricMap.put("Storage Metrics", objStorageMetrics);
//
//        Set<ObjectInstance> objMemoryMetrics = mbsc.queryMBeans(ObjectName
//                .getInstance("java.lang:type=Memory,name=Max"), null);
//        metricMap.put("Memory Metrics", objMemoryMetrics);
//
//        Set<ObjectInstance> objKeyspaceMetrics = mbsc.queryMBeans(ObjectName
//                .getInstance("org.apache.cassandra.metrics:type=Keyspace,scope=system,name=*"), null);
//        metricMap.put("Keyspace Metrics", objKeyspaceMetrics);

        // Print all the Cassandra metrics
        metricMap.forEach((k, v) -> {

            System.out.println("\n" + k + " Object Instances has " + v.size() + " objects.");

            for (ObjectInstance obj : v) {

                Object proxy = JMX.newMBeanProxy(mbsc, obj.getObjectName(),
                        CassandraMetricsRegistry.JmxCounterMBean.class);
                String objNameStr;
                if (proxy instanceof CassandraMetricsRegistry.JmxCounterMBean) {

                    objNameStr = ((CassandraMetricsRegistry.JmxCounterMBean) proxy).objectName().toString();

                    // objName comes like org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=Latency
                    int indexOfMetricName = objNameStr.lastIndexOf(',') + 6;
                    String metricName = objNameStr.substring(indexOfMetricName);

                    if (StringUtils.equalsIgnoreCase(DBClusterMetrics.LATENCY.name(), metricName)) {
                        // Do something here
                        System.out.println("Latency Metrics:");
                        System.out.println("Metric Name: " + ((CassandraMetricsRegistry.JmxCounterMBean) proxy).objectName()
                                + ", \nMetric Value: : " + ((CassandraMetricsRegistry.JmxCounterMBean) proxy).getCount());
                    } else if (StringUtils.equalsIgnoreCase("Failures", metricName)) {
                        // Do something here
                        System.out.println("Failures Metrics:");
                        System.out.println("Metric Name: " + ((CassandraMetricsRegistry.JmxCounterMBean) proxy).objectName()
                                + ", \nMetric Value: : " + ((CassandraMetricsRegistry.JmxCounterMBean) proxy).getCount());
                    }
                }
            }

        });

        jmxc.close();

    }

    enum DBClusterMetrics {
        LATENCY,
        FAILURES
    }

}
