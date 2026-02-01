

import com.config.Car;
import com.config.Plane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Plane planeBean = context.getBean("planeBean" , Plane.class);
        planeBean.setBrand("boeng");
        planeBean.saveToDatabase(planeBean);

        Car carBean = context.getBean("carBean" , Car.class);
        carBean.setBrand("BMW");
        carBean.saveToDatabase(carBean);

    }
}
