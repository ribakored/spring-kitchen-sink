package com.example.app1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    public static final Logger log = LoggerFactory.getLogger(AppConfig.class);
    private String timeout;
    private String message;
    public AppConfig(){
        log.info(String.format("Recreate App ConfigMap Object with values %s and %s ", this.timeout, this.message));
    }

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