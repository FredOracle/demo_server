package com.example.productservice.remote;

import com.example.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "orderClient",
        url = "http://localhost:8002/order"
)
public interface OrderClient {

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Order create(@RequestBody Order order);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Order update(@RequestBody Order order);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order update(@PathVariable("id") String id);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Order> list();

}

