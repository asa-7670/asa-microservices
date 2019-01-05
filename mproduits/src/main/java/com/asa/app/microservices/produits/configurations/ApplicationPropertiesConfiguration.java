package com.asa.app.microservices.produits.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app-produit-config")
public class ApplicationPropertiesConfiguration {
    private Integer prduitSize;

    public Integer getPrduitSize() {
        return prduitSize;
    }

    public void setPrduitSize(Integer prduitSize) {
        this.prduitSize = prduitSize;
    }
}
