import com.sun.org.apache.bcel.internal.generic.NEW;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import static java.util.stream.IntStream.of;

public class Main {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
        List<Student>students=new ArrayList<>();
        Collections.addAll(students,new Student("Ola"),new Student("Asmaa"),new Student("Amira"));
        List<Course>courses=new ArrayList<>();
        Collections.addAll(courses,new Course("OOP"),new Course("Java"),new Course("SpringBoot"));
        for(Course course:courses){
            course.setStudent(students);
            //session.save(course);
        }
        for(Student student:students){
            student.setCourseList(courses);
            session.save(student);
        }

            Student student1=  session.get(Student.class,1);
            System.out.println(student1.getName());
            List<Course>courses1=  student1.getCourseList();
            System.out.print("Courses are: ");
            for(Course c:courses1){
                System.out.print(c.getCourseName()+" ");
            }

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