package com.asa.app.microservices.commandes.controller;

import com.asa.app.microservices.commandes.dao.CommandesDao;
import com.asa.app.microservices.commandes.exceptions.CommandeNotFoundException;
import com.asa.app.microservices.commandes.exceptions.ImpossibleAjouterCommandeException;
import com.asa.app.microservices.commandes.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    private CommandesDao commandesDao;

    @PostMapping(value = "/Commandes")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande){
        return Optional.ofNullable(commande)
                .map(c->{
                    Commande newCommande = commandesDao.save(c);
                    if(Objects.isNull(newCommande)) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter la commande");
                    return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
                })
                .orElseThrow(()-> new IllegalArgumentException("La commande est requise"));
    }

    @GetMapping(value = "/Commandes/{id}")
    public Optional<Commande> getCommande(@PathVariable Integer id){
        return Optional.ofNullable(id)
                .map(i->{
                    Optional<Commande> result = commandesDao.findById(i);

                    if(!result.isPresent()) throw new CommandeNotFoundException("Commande non trouvé");
                    return result;
                })
                .orElseThrow(()->new IllegalArgumentException("l'identifiant de la commande est requis"));
    }
}
