package com.adminPanel.app.service;

import com.adminPanel.app.Entity.Product;
import com.adminPanel.app.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public final  ProductRepository repo;
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
    public List<Product> getProducts() {
        return repo.findAll();
    }
    public Page<Product> getProducts(int page, int size) {
         Pageable pageable =  PageRequest.of(page, size);
        return repo.findAll(pageable);
    }
    public Product saveProduct(Product product) {
            return repo.save(product);
    }
    public void deleteProduct(Long id) {
            repo.deleteById(id);
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
