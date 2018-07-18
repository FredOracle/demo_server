package com.example.common.task;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RefreshConfigJob {


    @Scheduled(fixedRate = 5000)
    public void refreshConfig(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.postForObject("http://localhost:8004/actuator/refresh",HttpEntity.EMPTY,  Object.class);
    }

}
