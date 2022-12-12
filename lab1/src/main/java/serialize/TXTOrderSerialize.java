 package serialize;

import model.Order;

import java.io.*;
import java.util.List;

public class TXTOrderSerialize implements ISerialize<Order> {
    public TXTOrderSerialize() {
    }

    @Override
    public Order readObject(String fileName) throws IOException {

        return null;
    }

    @Override
    public void writeObject(String fileName, Order object) throws IOException {

        FileWriter f1 = new FileWriter(new File(fileName));
        f1.write(object.toString());
        f1.close();
    }

    @Override
    public List<Order> readListObject(String fileName) throws IOException {
        return null;
    }

    @Override
    public void writeListObject(String fileName, List<Order> objects) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(fileName));
        ObjectOutputStream o = new ObjectOutputStream((f));
        o.writeObject(objects.toString());
        o.close();
        f.close();
    }
}
