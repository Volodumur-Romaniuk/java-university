 package com.example.pharmacy.serialize;




import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.example.pharmacy.model.Order;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONOrderSerialize implements  ISerialize<Order>{
    private ObjectMapper mapper;
    public JSONOrderSerialize() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public Order readObject(String fileName) throws IOException {
        return mapper.readValue(new File(fileName), Order.class);
    }

    @Override
    public void writeObject(String fileName, Order object) throws IOException {
        mapper.writeValue(new File(fileName),object);
    }

    @Override
    public List<Order> readListObject(String fileName) throws IOException {

        return mapper.readerForListOf(Order.class).readValue(new File(fileName));

    }

    @Override
    public void writeListObject(String fileName, List<Order> objects) throws IOException {
        mapper.writeValue(new File(fileName),objects);
    }
}
