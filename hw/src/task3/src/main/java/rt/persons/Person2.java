package rt.persons;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person2 extends Person implements Externalizable {

    public Person2(String name, int age, long passportNum) {
        super(name, age, passportNum);
    }

    public Person2() {
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        passportNum = in.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeLong(passportNum);
    }
}
