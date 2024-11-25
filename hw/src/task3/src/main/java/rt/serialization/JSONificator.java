package rt.serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONificator {

    private static final String EXTENSION = ".json";
    private static final ObjectMapper OM = new ObjectMapper();

    public static <T> void writeToJSON(T o, String fileName) {
        OM.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            OM.writeValue(new File(fileName + EXTENSION), o);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static <T> T readFromJSON(Class<T> clasz, String fileName) {
        File file = new File(fileName + EXTENSION);
        if (file.exists()) {
            try {
                return OM.readValue(file, clasz);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;

    }

}
