package com.asa.app.microservices.client.proxy;

import com.asa.app.microservice.core.model.impl.ProductImpl;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "asa-api-produits")
@RibbonClient(name = "asa-api-produits")
public interface ProductProxy {

    @GetMapping(value = "/Produits")
    List<ProductImpl> getProduts();

    @GetMapping( value = "/Produits/{uuid}")
    ProductImpl getProduct(@PathVariable("uuid") UUID uuid);

}
