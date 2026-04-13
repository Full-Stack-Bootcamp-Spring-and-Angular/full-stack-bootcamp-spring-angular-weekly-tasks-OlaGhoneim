package com.adminPanel.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adminPanel.app.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {



}
