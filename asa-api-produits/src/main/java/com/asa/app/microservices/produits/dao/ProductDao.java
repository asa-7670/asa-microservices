package com.asa.app.microservices.produits.dao;

import com.asa.app.microservices.produits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDao extends JpaRepository<Produit, UUID> {
}
