package solution;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLOrderSerialize implements  ISerialize {

    public XMLOrderSerialize() {
    }
    @Override
    public Object readObject(String fileName) throws IOException {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        var objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
        var value = objectMapper.readValue(new File(fileName), Order.class);
        return value;
    }

    @Override
    public void writeObject(String fileName, Object object) throws IOException {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        var objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(new File(fileName),object);
    }

    @Override
    public List<Object> readListObject(String fileName) throws IOException {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        var objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
        List value = objectMapper.readerForListOf(Order.class).readValue(new File(fileName));
        return value;
    }

    @Override
    public void writeListObject(String fileName, List<Object> objects) throws IOException {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        var objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(new File(fileName),objects);
    }
}
