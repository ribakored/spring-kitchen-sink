package com.example.app1;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String timeout;
    private String message;
    public String getTimeout() {
        return timeout;
    }
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}