package com.asa.app.microservices.paiement.dao;

import com.asa.app.microservices.paiement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Integer> {
}
