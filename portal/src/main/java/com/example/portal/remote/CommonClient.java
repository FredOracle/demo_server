package com.example.portal.remote;

import com.example.common.entity.Demo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "commonClient",
        url = "http://localhost:10000/common"
)
public interface CommonClient {

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public Demo create();

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.PUT)
    public Demo update(@PathVariable("id") String id);

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id);

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public List<Demo> list();

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
    public Optional<Demo> load(@PathVariable("id") String id);


}
