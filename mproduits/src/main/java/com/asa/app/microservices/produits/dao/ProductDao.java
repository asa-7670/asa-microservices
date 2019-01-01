package com.asa.app.microservices.produits.dao;

import com.asa.app.microservices.produits.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
