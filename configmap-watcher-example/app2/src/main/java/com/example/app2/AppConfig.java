package com.example.app2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    public static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    public AppConfig(){
        log.info(String.format("Recreate App ConfigMap Object with values %s and %s ", this.timeout, this.message));
    }
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