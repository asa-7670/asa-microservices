package com.asa.app.microservices.paiement.controller;

import com.asa.app.microservices.paiement.dao.PaiementDao;
import com.asa.app.microservices.paiement.exceptions.PaiementExistantException;
import com.asa.app.microservices.paiement.exceptions.PaiementImpossibleException;
import com.asa.app.microservices.paiement.model.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
public class PaiementController {
    @Autowired
    private PaiementDao paiementDao;

    @PostMapping(value = "/Paiement")
    public ResponseEntity<Paiement> payOrder(@RequestBody Paiement paiement){
        return Optional.ofNullable(paiement)
                //.filter TODO
                .map(p->{
                    //SEARCh PAIEMENT
                    Optional<Paiement> pExist = paiementDao.findById(p.getId());
                    if(pExist.isPresent())throw new PaiementExistantException("Commande déja payée");
                    //SAVE PAIEMENT
                    Paiement newPaiement = paiementDao.save(p);
                    if(Objects.isNull(newPaiement)) throw new PaiementImpossibleException("Erreur, impossible d'atablir le paiement, réessayer plus tard");

                    //TODO CALL COMMANDES MICROSERVICE

                    return new ResponseEntity<Paiement>(newPaiement, HttpStatus.CREATED);

                })
                .orElseThrow(()-> new IllegalArgumentException("Ordre de paiement est requis"));
    }

}
