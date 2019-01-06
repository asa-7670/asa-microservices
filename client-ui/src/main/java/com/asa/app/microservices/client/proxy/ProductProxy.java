package com.asa.app.microservices.client.proxy;

import com.asa.app.microservice.core.model.impl.ProductImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "asa-microservice-produits", url = "localhost:9010")
public interface ProductProxy {

    @GetMapping(value = "asaProduits/Produits")
    List<ProductImpl> getProduts();

    @GetMapping( value = "asaProduits/Produits/{uuid}")
    ProductImpl getProduct(@PathVariable("uuid") UUID uuid);

}