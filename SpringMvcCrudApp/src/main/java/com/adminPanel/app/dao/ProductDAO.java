package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductDAO {
    Product insert(ProductDetails product);
    Product findById(int id);
   // Product update(Product product);
    List<Product> getAllProducts();
    void deleteById(int id);
    void updateDetails(ProductDetails productDetails);

}
