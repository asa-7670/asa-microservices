package com.asa.app.microservices.client.controller;

import com.asa.app.microservice.core.model.impl.ProductImpl;
import com.asa.app.microservices.client.proxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ClientController {
    @Autowired
    private ProductProxy productProxy;

    @RequestMapping("/")
    public String acceuil(Model model){
        List<ProductImpl> products = productProxy.getProduts();
        model.addAttribute("products", products);
        return "Accueil";
    }

    @RequestMapping("/details-produit/{uuid}")
    public String ficheProduit(@PathVariable UUID uuid, Model model){
        ProductImpl product = productProxy.getProduct(uuid);
        model.addAttribute("product", product);
        return "FicheProduit";
    }
}
