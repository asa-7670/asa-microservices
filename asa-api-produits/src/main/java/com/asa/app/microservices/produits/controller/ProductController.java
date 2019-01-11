package com.asa.app.microservices.produits.controller;

import com.asa.app.microservices.produits.configurations.ApplicationPropertiesConfiguration;
import com.asa.app.microservices.produits.dao.ProductDao;
import com.asa.app.microservices.produits.exceptions.ProductNotFoundException;
import com.asa.app.microservices.produits.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    ApplicationPropertiesConfiguration appProperties;

    @GetMapping(value = "/Produits", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produit> getProducts(){
        List<Produit> result= productDao.findAll();
        if(Objects.isNull(result) || result.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");
        //limite le resultat
        List<Produit> listelimitee = result.subList(0,appProperties.getPrduitSize());
        return listelimitee;
    }

    @GetMapping(value = "/Produits/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Produit> getProduct(@PathVariable UUID uuid){
        return Optional.ofNullable(uuid)
                .map(id->{
                    Optional<Produit> result=  productDao.findById(id);
                    if(!result.isPresent()) throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");
                    return result;
                })
                .orElseThrow(()-> new IllegalArgumentException("L'identifiant du produit est requis"));
    }
}
