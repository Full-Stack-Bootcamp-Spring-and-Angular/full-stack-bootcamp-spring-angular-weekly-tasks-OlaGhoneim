package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class productService {
    @Autowired
    private ProductDAO productDAO;
    public Product insert(ProductDetails product){
        return productDAO.insert(product);
    }
    public   Product findById(int id){
        return productDAO.findById(id);
    }
//    public    Product update(Product product){
//        return productDAO.update(product);
//    }
    public void updateDetails(ProductDetails productDetails) {
        productDAO.updateDetails(productDetails);
    }
    public   List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }
     public void deleteById(int id){
        productDAO.deleteById(id);
    }


}
