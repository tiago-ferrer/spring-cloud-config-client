package br.com.fiap.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RefreshScope
@RestController
public class SampleRestController {


    @Value("${teste-app.api}")
    private String uriApi;

    private final RestClient restClient = RestClient.create();

    @GetMapping("/get")
    public Object getFromService(){
        return restClient.get().uri(this.uriApi).retrieve().toEntity(Object.class).getBody();
    }

}
