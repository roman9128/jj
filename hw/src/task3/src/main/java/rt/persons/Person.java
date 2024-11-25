package rt.persons;

import java.io.Serializable;

public class Person implements Serializable {

    protected String name;
    protected int age;
    protected transient long passportNum;

    public Person(String name, int age, long passportNum) {
        this.age = age;
        this.name = name;
        this.passportNum = passportNum;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(long passportNum) {
        this.passportNum = passportNum;
    }

    @Override
    public String toString() {
        return "Person [name: " + name + ", age: " + age + ", passportNum: " + passportNum + "]";
    }

}
