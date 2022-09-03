package com.example.configclient1.resource;

import com.example.configclient1.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    private AppConfig appConfig;

    public ConfigClientController(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    @GetMapping("/timeout")
    public String getTimeout(){
        return String.format("Timeout=%s",appConfig.getTimeout());
    }

}
