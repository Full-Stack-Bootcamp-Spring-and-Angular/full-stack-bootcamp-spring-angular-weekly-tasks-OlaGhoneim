import com.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circleShape = context.getBean("circle" , Shape.class);
        circleShape.drawShape2d();

        Shape rectangleShape = context.getBean("rectangle" , Shape.class);
        rectangleShape.drawShape2d();

    }
}