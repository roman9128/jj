package rt.serialization;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONificator {

    private static final String EXTENSION = ".json";
    private static final ObjectMapper OM = new ObjectMapper();

    public static <T> void writeToJSON(T object, String fileName) {
        OM.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            OM.writeValue(new File(fileName + EXTENSION), object);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // для объекта
    public static <T> T readFromJSON(Class<T> objClass, String fileName) {
        File file = new File(fileName + EXTENSION);
        if (file.exists()) {
            try {
                return OM.readValue(file, objClass);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    // для коллекции
    public static <C extends Collection<?>> C readFromJSON(Class<C> collectionClass, Class<?> collectionObjectClass, String fileName) {
        File file = new File(fileName + EXTENSION);
        if (file.exists()) {
            try {
                return OM.readValue(file, OM.getTypeFactory().constructCollectionType(collectionClass, collectionObjectClass));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

}
