package task3_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main3 {

    public static void main(String[] args) {

        UserData user1 = new UserData("Stacy", 32, "1712");
        String path = "nastiush.ka";

        serializeIt(user1, path);

        System.out.println((UserData) deserializeIt(path));

    }

    private static <T> void serializeIt(T o, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(o);
            System.out.println("success");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Object deserializeIt(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            System.out.println("success");
            return ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
