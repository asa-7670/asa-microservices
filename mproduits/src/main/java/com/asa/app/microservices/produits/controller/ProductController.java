package com.asa.app.microservices.produits.controller;

import com.asa.app.microservices.produits.dao.ProductDao;
import com.asa.app.microservices.produits.exceptions.ProductNotFoundException;
import com.asa.app.microservices.produits.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/Produits")
    public List<Product> getProducts(){
        List<Product> result= productDao.findAll();
        if(Objects.isNull(result) || result.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");
        return result;
    }

    @GetMapping(value = "/Produits/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id){
        return Optional.ofNullable(id)
                .map(i->{
                    Optional<Product> result=  productDao.findById(i);
                    if(!result.isPresent()) throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");
                    return result;
                })
                .orElseThrow(()-> new IllegalArgumentException("L'identifiant du produit est requis"));
    }
}
