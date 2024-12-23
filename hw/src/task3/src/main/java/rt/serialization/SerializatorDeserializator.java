package rt.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializatorDeserializator {

    private static final String EXTENSION = ".bin";

    public static <T> void serializeIt(T o, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + EXTENSION))) {
            System.out.println("your object is successfully serialized");
            oos.writeObject(o);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Object deserializeIt(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + EXTENSION))) {
            System.out.println("deserialization completed");
            return ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static <T> T deserializeIt(Class<T> objClass, String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + EXTENSION))) {
            System.out.println("deserialization completed");
            return (T) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
