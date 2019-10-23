package main;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import model.Phone;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.CassandraDB;

import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        String query = "SELECT * FROM phone";

        try { ;
            Session session = CassandraDB.connect();
            ResultSet resultSet = session.execute(query);

            System.out.println("\n" + resultSet.all() + "\n");

            MappingManager manager = new MappingManager(session);
            Mapper<Phone> mapper = manager.mapper(Phone.class);

            Phone phone = mapper.get(UUID.fromString("6e6ab900-f1ea-11e9-afd1-07de00b0189d"), "001");

            System.out.println("\n" + phone.toString() + "\n");

            Result<Phone> phones = mapper.map(session.execute(query));
            for (Phone p : phones) {
                System.out.println(p.toString());
            }

        } finally {
            if (CassandraDB.getSession() != null) {
                CassandraDB.shutdown();
            }
        }

    }
}
