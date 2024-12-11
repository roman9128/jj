package rt.serialization;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLficator {

    private static final String EXTENSION = ".xml";
    private static final XmlMapper XM = new XmlMapper();

    public static <T> void writeToXML(T object, String fileName) {
        try {
            XM.writeValue(new File(fileName + EXTENSION), object);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // для объекта
    public static <T> T readFromXML(Class<T> objClass, String fileName) {
        File file = new File(fileName + EXTENSION);
        if (file.exists()) {
            try {
                return XM.readValue(file, objClass);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    // для коллекции
    public static <C extends Collection<?>> C readFromXML(Class<C> collectionClass, Class<?> collectionObjectClass, String fileName) {
        File file = new File(fileName + EXTENSION);
        if (file.exists()) {
            try {
                return XM.readValue(file, XM.getTypeFactory().constructCollectionType(collectionClass, collectionObjectClass));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }
}