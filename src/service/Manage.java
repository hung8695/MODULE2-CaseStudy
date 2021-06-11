package service;

import java.util.List;

public interface Manage<T> {
    public void creat(T t);
    public void display();
    //public List<T>find();
    public boolean delete(String code);
    public T update(String code);
    public void sort();
}
