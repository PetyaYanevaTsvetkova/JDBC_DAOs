package daoService;

import java.util.List;

public interface DAO<T> {

    void save(T object);

    void deleteById(Long id);

    void deleteAll();

    T getById(Long id);

    List<T> getByIds(List<Long> ids);

    int getAllRecordsCount();

    T getRandomId();

    List<T> getRandomIds(int randomCount);

}
