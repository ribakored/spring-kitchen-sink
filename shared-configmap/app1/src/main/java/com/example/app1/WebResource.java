package com.example.app1;

import com.example.app1.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebResource {
    private AppConfig appConfig;
    public WebResource(AppConfig appConfig){
        this.appConfig = appConfig;
    }
    @GetMapping(value = "/propertyValues")
    public @ResponseBody String getPropertyValues(){
        return String.format("\nTimeout=%s, Message=%s, Shared Message=%s",
                appConfig.getTimeout(),
                appConfig.getMessage(),
                appConfig.getShared());
    }
}