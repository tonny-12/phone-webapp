package dao;

import java.util.List;
import java.util.UUID;

public interface Dao<T> {

    T get(UUID uuid);
    List<T> getAll();
    void create(T t);
    void update(T t);
    void delete(T t);

}
