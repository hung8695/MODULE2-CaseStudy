package io;

import java.io.IOException;
import java.util.List;

public interface IO <T>{
    void write (String path, List<T> list) throws IOException;
    List<T> read(String path) throws IOException;
}
