package solution;

import java.io.*;
import java.util.List;

public class TXTOrderSerialize implements ISerialize{
    public TXTOrderSerialize() {
    }

    @Override
    public Object readObject(String fileName) throws IOException {

        return null;
    }

    @Override
    public void writeObject(String fileName, Object object) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(fileName));
        ObjectOutputStream o = new ObjectOutputStream((f));
        o.writeObject(object.toString());
        o.close();
        f.close();
    }

    @Override
    public List<Object> readListObject(String fileName) throws IOException {
        return null;
    }

    @Override
    public void writeListObject(String fileName, List<Object> objects) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(fileName));
        ObjectOutputStream o = new ObjectOutputStream((f));
        o.writeObject(objects.toString());
        o.close();
        f.close();
    }
}
