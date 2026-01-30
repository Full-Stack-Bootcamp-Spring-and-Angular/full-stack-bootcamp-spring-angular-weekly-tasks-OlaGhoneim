package main;

import main.com.myApp.controller.Entity.Passport;
import main.com.myApp.controller.Entity.Person;
import main.com.myApp.controller.Entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.util.List;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import static java.util.stream.IntStream.of;

public class Main
{
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
//            session.beginTransaction();
//      Person person = new Person("Ola","Ghoneim","1234");
//      Passport passport=new Passport("108e5",LocalDate.of(2026,1,30));
//      passport.setPerson(person);
//      session.save(passport);
//      session.getTransaction().commit();
   session.beginTransaction();
      Person person=session.get(Person.class, 1);
      System.out.println(person);
      session.getTransaction().commit();

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}
