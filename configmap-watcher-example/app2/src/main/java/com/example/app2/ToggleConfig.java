package com.example.app2;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "shared")
public class ToggleConfig {

    private String toggleA;

    public String getToggleA() {
        return toggleA;
    }

    public void setToggleA(String toggleA) {
        this.toggleA = toggleA;
    }
}
