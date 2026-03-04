package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Product insert(ProductDetails productDetails) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Product product = new Product();
            product.setName(productDetails.getName());
            product.setProductDetails(productDetails);
            productDetails.setProduct(product);
            session.save(product);
            return product;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Product product = (Product) session.get(Product.class, id);
            return product;


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }



    @Override
    public void updateDetails(ProductDetails productDetails) {
        try {
            Session session = sessionFactory.getCurrentSession();


            ProductDetails current  = (ProductDetails) session.get(ProductDetails.class, productDetails.getId());

            current.setName(productDetails.getName());
            current.setAvailable(productDetails.isAvailable());
            current.setPrice(productDetails.getPrice());
            current.setExpirationDate(productDetails.getExpirationDate());
            current.setManufacturer(productDetails.getManufacturer());


            Product product = current.getProduct();
            product.setName(current.getName());

            session.merge(current);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public List<Product> getAllProducts() {
        try{
            Session session = sessionFactory.getCurrentSession();
           List< Product> products =session.createQuery("from Product").list();
            return products;


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public void deleteById(int id) {
        try{
         Session session = sessionFactory.getCurrentSession();
            Product product = (Product) session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }


}
