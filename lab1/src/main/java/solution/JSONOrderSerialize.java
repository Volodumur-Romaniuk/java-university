package solution;




import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.JsonGenerator;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JSONOrderSerialize implements  ISerialize{

    public JSONOrderSerialize() {
    }

    @Override
    public Object readObject(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        var value = mapper.readValue(new File(fileName), Order.class);
        return value;
    }

    @Override
    public void writeObject(String fileName, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.writeValue(new File(fileName),object);
    }

    @Override
    public List<Object> readListObject(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
       mapper.registerModule(new JavaTimeModule());
        List value = mapper.readerForListOf(Order.class).readValue(new File(fileName));
        return value;
    }

    @Override
    public void writeListObject(String fileName, List<Object> objects) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.writeValue(new File(fileName),objects);
    }
}
