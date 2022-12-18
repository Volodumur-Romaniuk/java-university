package com.example.pharmacy.serialize;

import com.example.pharmacy.model.Order;

import java.io.*;
import java.util.List;


public class TXTOrderSerialize implements ISerialize<Order> {
    private FileWriter fWrite;

    public TXTOrderSerialize() {
    }

    @Override
    public Order readObject(String fileName) throws IOException, InstantiationException, IllegalAccessException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String objectLine = sb.toString();
        return (Order) Order.class.newInstance();

    }

    @Override
    public void writeObject(String fileName, Order object) throws IOException {

        fWrite = new FileWriter(new File(fileName));
        fWrite.write(object.toString());
        fWrite.close();
    }

    @Override
    public List<Order> readListObject(String fileName) throws IOException {
        return null;
    }

    @Override
    public void writeListObject(String fileName, List<Order> objects) throws IOException {
        fWrite = new FileWriter(new File(fileName));
        fWrite.write(objects.toString());
        fWrite.close();
    }
}
