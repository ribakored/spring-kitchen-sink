package com.example.app2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebResource {
    private AppConfig appConfig;
    private ToggleConfig toggleConfig;
    public WebResource(AppConfig appConfig, ToggleConfig toggleConfig){
        this.appConfig = appConfig;
        this.toggleConfig = toggleConfig;
    }
    @GetMapping(value = "/propertyValues")
    public @ResponseBody String getPropertyValues(){
        return String.format("\nTimeout=%s, Message=%s, Shared Message=%s",
                appConfig.getTimeout(),
                appConfig.getMessage(),
                toggleConfig.getToggleA());
    }
}