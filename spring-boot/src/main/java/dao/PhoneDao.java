package dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import model.Phone;
import util.CassandraDB;

import java.util.List;
import java.util.UUID;

public class PhoneDao implements Dao<Phone> {

    private Session session = CassandraDB.connect();
    private Mapper<Phone> phoneMapper = new MappingManager(session).mapper(Phone.class);

    @Override
    public Phone get(UUID uuid) {
        String query = String.format("SELECT * FROM phone_webapp.phone WHERE uuid=%s", uuid);
        ResultSet resultSet = session.execute(query);
        return phoneMapper.map(resultSet).one();
    }

    @Override
    public List<Phone> getAll() {
        String query = "SELECT * FROM phone_webapp.phone";
        ResultSet resultSet = session.execute(query);
        return phoneMapper.map(resultSet).all();
    }

    @Override
    public void create(Phone phone) {
        phoneMapper.save(phone);
    }

    @Override
    public void update(Phone phone) {
        String query = String.format("SELECT * FROM phone_webapp.phone WHERE uuid=%s", phone.getUuid());
        ResultSet resultSet = session.execute(query);
        Phone oldPhone = phoneMapper.map(resultSet).one();
        if (oldPhone != null
                && oldPhone.getUuid().equals(phone.getUuid())
                && oldPhone.getPhoneId().equals(phone.getPhoneId())) {
            phoneMapper.save(phone);
        }
    }

    @Override
    public void delete(Phone phone) {
        phoneMapper.delete(phone.getUuid(), phone.getPhoneId());
    }
}
