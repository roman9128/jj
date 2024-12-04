package rt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseMaster {

    private final SessionFactory sf;

    public DataBaseMaster(Class<? extends Object> objClass) {
        sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(objClass)
                .buildSessionFactory();
    }

    public void writeListOfObjectsToDB(List<? extends Object> objects) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            objects.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public <T> void addObjectToDB(T object) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public <T> void removeFromDB(T object) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            session.remove(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
