package com.asa.app.microservices.produits.model;

import com.asa.app.microservice.core.model.Product;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Produit implements Product {

    @Id
    @Type(type="uuid-char")
    @Column(name = "PRD_UUID", nullable = false)
    private UUID uuid;

    @Column(name = "PRD_TITLE", nullable = false, length = 100)
    @Size(min = 10, max = 100)
    private String title;

    @Column(name = "PRD_DESCRIPTION", nullable = false, length = 500)
    @Size(min = 25, max = 500)
    private String description;

    @Column(name = "PRD_IMAGE", nullable = false)
    private String image;

    @Column(name = "PRD_PRICE", nullable = false)
    private Double price;

    public Produit() {
    }

    public Produit(UUID uuid, String description, String image, Double price) {
        this.uuid = uuid;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;

    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

}
