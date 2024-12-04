package models;

import java.util.Random;

public class Student {

    private static final Random random = new Random();
    private static String[] names = {"Tom", "Bob", "Jon", "Don", "Mike", "Raph", "Steve", "Leo"};

    private int id;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public static Student create() {
        return new Student(names[random.nextInt(names.length)], random.nextInt(18, 30));
    }

    public void updateAge() {
        age = random.nextInt(18, 30);
    }

    public void updateName() {
        name = names[random.nextInt(names.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
