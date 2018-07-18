package com.example.userservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "commonClient", url = "${common-url}")
public interface CommonClient {

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg();
}
