package com.example.pharmacy.serialize;

import com.example.pharmacy.model.Order;

import java.io.IOException;
import java.util.List;

public interface ISerialize<T> {
    T readObject(String fileName) throws IOException, InstantiationException, IllegalAccessException;

    void writeObject(String fileName, T object) throws IOException;

    List<T> readListObject(String fileName) throws IOException;

    void writeListObject(String fileName, List<T> objects) throws IOException;


}
