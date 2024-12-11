package rth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        try (SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student2.class)
                .buildSessionFactory()) {

            Session session = sf.getCurrentSession(); // создание сессии

            session.beginTransaction(); // начать транзакцию

            Student2 student = Student2.create();
            session.save(student);
            System.out.println("saved");
            // Student2 dbStudent = session.get(Student2.class, 30);
            // dbStudent.updateAge();
            // dbStudent.updateName();
            // session.update(dbStudent);
            // System.out.println(dbStudent);
            // session.delete(dbStudent);

            session.getTransaction().commit(); // выполнить запрос, завершить транзакцию

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
