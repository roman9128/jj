package rt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import models.Student;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
           
            createDB(connection);
            System.out.println("create DB - success");

            useDB(connection);
            System.out.println("use DB - success");
            
            createTable(connection);
            System.out.println("create table - success");

            int count = new Random().nextInt(5, 10);
            for (int i = 0; i < count; i++) {
                insertData(connection, Student.create());
            }
            System.out.println("insert data - success");

            Collection<Student> students = readData(connection);
            students.forEach(System.out::println);

            for (Student student : students) {
                student.updateName();
                student.updateAge();
                updateData(connection, student);
            }
            students.forEach(System.out::println);

            // for (Student student : students) {
            //     removeData(connection, student.getId());
            // }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDB(Connection connection) throws SQLException {
        String createDB = "CREATE DATABASE IF NOT EXISTS students;";
        try (PreparedStatement statement = connection.prepareStatement(createDB)) {
            statement.execute();
        }
    }

    private static void useDB(Connection connection) throws SQLException {
        String useDB = "USE students;";
        try (PreparedStatement statement = connection.prepareStatement(useDB)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTable)) {
            statement.execute();
        }
    }

    private static void insertData(Connection connection, Student student) throws SQLException {
        String insertData = "INSERT INTO students (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertData)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.execute();
        }
    }

    private static void updateData(Connection connection, Student student) throws SQLException {
        String updateData = "UPDATE students SET name=?, age=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateData)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();

        }
    }

    private static void removeData(Connection connection, int id) throws SQLException {
        String removeData = "DELETE FROM students WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(removeData)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private static Collection<Student> readData(Connection connection) throws SQLException {
        ArrayList<Student> studList = new ArrayList<>();
        String readData = "SELECT * FROM students;";
        try (PreparedStatement statement = connection.prepareStatement(readData)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                studList.add(new Student(id, name, age));
            }
            return studList;
        }
    }
}
