package util;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraDB {

    private volatile static Cluster cluster;
    private volatile static Session session;

    private CassandraDB() {

    }

    public static Session connect() {
        if (cluster == null && session == null) {
            cluster = Cluster.builder()
                    .addContactPoint("127.0.0.1")
                    .withoutJMXReporting()
                    .build();
            session = cluster.connect("phone_webapp");
        }
        return session;
    }

    public static void shutdown() {
        session.close();
        cluster.close();
    }

    public static Session getSession() {
        if (session == null) {
            synchronized (CassandraDB.class) {
                if (session == null) {
                    session = connect();
                }
            }
        }
        return session;
    }

}
