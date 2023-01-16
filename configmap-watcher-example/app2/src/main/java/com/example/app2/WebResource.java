package com.example.app2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebResource {
    private AppConfig appConfig;
    private SharedConfig sharedConfig;
    public WebResource(AppConfig appConfig, SharedConfig sharedConfig){
        this.appConfig = appConfig;
        this.sharedConfig = sharedConfig;
    }
    @GetMapping(value = "/propertyValues")
    public @ResponseBody String getPropertyValues(){
        return String.format("\nTimeout=%s, Message=%s, Shared Message=%s",
                appConfig.getTimeout(),
                appConfig.getMessage(),
                sharedConfig.getToggleA());
    }
}