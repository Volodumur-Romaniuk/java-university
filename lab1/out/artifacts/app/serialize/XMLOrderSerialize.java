package serialize;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Order;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLOrderSerialize implements  ISerialize<Order> {
    private XmlMapper objectMapper;
    public XMLOrderSerialize() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
    }
    @Override
    public Order readObject(String fileName) throws IOException {
        return  objectMapper.readValue(new File(fileName), Order.class);
    }

    @Override
    public void writeObject(String fileName, Order object) throws IOException {
        objectMapper.writeValue(new File(fileName),object);
    }

    @Override
    public List<Order> readListObject(String fileName) throws IOException {
        return objectMapper.readerForListOf(Order.class).readValue(new File(fileName));
    }

    @Override
    public void writeListObject(String fileName, List<Order> objects) throws IOException {
        objectMapper.writeValue(new File(fileName),objects);
    }
}
