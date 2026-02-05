import com.sun.org.apache.bcel.internal.generic.NEW;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.util.*;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import static java.util.stream.IntStream.of;

public class Main2 {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
           Instructor instructor=new Instructor("Ola");
           Collection<Course>Courses=new ArrayList<>();
           Courses.addAll(Arrays.asList(new Course ("Java"),new Course ("OOP"),new Course("Python")));
           for(Course c:Courses){
               c.setInstructor(instructor);
           }
            instructor.setCourseList((List<Course>) Courses);

           //I save only instructor ,but because of property cascade ,the courses are already saved
            session.save(instructor);
           session.getTransaction().commit();


        }
        catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }



    }
}