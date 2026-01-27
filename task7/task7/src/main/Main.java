package main;

import main.com.myApp.controller.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main
{
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
            //create
//            User user = new User(2,"admin","admin","admin@admin.com");
//            //open the transaction
//          session.beginTransaction();
//            //save into database
//              session.save(user);
//            //commit the changes
//            session.getTransaction().commit();

            //delete
//        session.beginTransaction();
//       User user= session.get(User.class, 1);
//       session.delete(user);
//       session.getTransaction().commit();

            //update
            session.beginTransaction();
            User user = session.get(User.class, 3);
            user.setEmail("test@test.com");
            session.update(user);
            session.getTransaction().commit();


        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}
