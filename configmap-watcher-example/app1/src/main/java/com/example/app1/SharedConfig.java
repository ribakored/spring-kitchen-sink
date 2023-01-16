package com.example.app1;


import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

@Configuration
@RefreshScope
public class SharedConfig {

    public static final Logger log = LoggerFactory.getLogger(SharedConfig.class);
    public SharedConfig() throws IOException, ApiException {
        ApiClient client = Config.defaultClient();
        io.kubernetes.client.openapi.Configuration.setDefaultApiClient(client);
        CoreV1Api api = new CoreV1Api();
        V1ConfigMap configMap = api.readNamespacedConfigMap("shared","default",null);
        Map<String, String> configmapData = configMap.getData();
        if(configmapData!=null){
            log.info(String.format("configmapData: %s",configmapData.toString()));
            this.setToggleA(configmapData.get("shared.toggleA"));
        }
    }

    private String toggleA;
    public String getToggleA() {
        return toggleA;
    }

    public void setToggleA(String toggleA) {
        this.toggleA = toggleA;
    }

}
