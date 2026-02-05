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
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            Question question= new Question("What is your name?");
            List<Answer> answers=new ArrayList<>();
            Collections.addAll(answers,new Answer("Ali"),new Answer("Ahmed"),new Answer("Mohamed"));
          question.setAnswers(answers);
            session.save(question);
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