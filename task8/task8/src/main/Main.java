package main;

import main.com.myApp.controller.Entity.Product;
import main.com.myApp.controller.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
            // ===== FIRST TRANSACTION (READ) =====
            session.beginTransaction();
       Query query1=session.createQuery("from Product");
       List<Product> productList=query1.getResultList();
       for(Product product:productList){
           System.out.println(product.toString());
       }


            // ===== SECOND TRANSACTION (UPDATE) =====
      Query query2 =session.createQuery("update Product set price =:price where id=:id");
      query2.setParameter("price",15);
      query2.setParameter("id",5);
      int status =query2.executeUpdate();
            if (status==1)
                System.out.println("Update is done" );
            else
                System.out.println("Update failed");

            // ===== THIRD TRANSACTION (GET RECORDS WITH PAGINATION) =====
             Query query3=session.createQuery("from Product");
             query3.setFirstResult(2);
             query3.setMaxResults(5);
             List<Product> productList2=query3.getResultList();
             for(Product product2:productList2){
                 System.out.println(product2.toString());
             }
            // ===== Fourth TRANSACTION (Aggregrate Functions ) =====

            Integer maxPrice= (Integer)(session.createQuery("select max(price) from Product")).getSingleResult();

            System.out.println("Max price is "+maxPrice);



      Query query4=session.createQuery("select sum(price)from Product");
      List<Integer> productList4=query4.getResultList();

          System.out.println("Sum of product prices ="+ productList4.get(0));
            session.getTransaction().commit();

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}
