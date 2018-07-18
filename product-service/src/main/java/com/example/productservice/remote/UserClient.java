package com.example.productservice.remote;

import com.example.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "userClient",
        url = "http://localhost:8001/user"

)
public interface UserClient {

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User create(@RequestBody User user);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public User update(@RequestBody User user);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") String id);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") String id);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list();
}
