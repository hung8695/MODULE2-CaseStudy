package service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    T findById(String id);
    void add(T t);
    void edit(String id);
    void delete(String id);
}
