package com.asa.app.microservice.core.model;

import java.util.UUID;

public interface Product {

    UUID getUuid();
    void setUuid(UUID uuid);

    String getTitle();
    void setTitle(String title);

    String getDescription();
    void setDescription(String description);

    String getImage();
    void setImage(String image);

    Double getPrice();
    void setPrice(Double price);
}
