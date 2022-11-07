package solution;

import java.io.IOException;
import java.util.List;

public interface ISerialize {
    Object readObject(String fileName) throws IOException;

    void writeObject(String fileName, Object object) throws IOException;

    List<Object> readListObject(String fileName) throws IOException;

    void writeListObject(String fileName, List<Object> objects) throws IOException;

}
