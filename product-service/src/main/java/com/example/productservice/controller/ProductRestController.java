package com.example.productservice.controller;

import com.example.common.config.ProductConfigProperties;
import com.example.common.entity.Product;
import com.example.productservice.business.ProductBusiness;
import com.example.productservice.remote.OrderClient;
import com.example.productservice.remote.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductRestController {

    @Resource
    private ProductConfigProperties properties;

    @Resource
    private ProductBusiness productBusiness;
    
    @Resource
    private OrderClient orderClient;

    @Resource
    private UserClient userClient;



    @HystrixCommand
    @Transactional
    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg(){
//        User user = userClient.create(User.builder().name(UUID.randomUUID().toString()).age(100).password(UUID.randomUUID().toString()).description("").createtime(new Date()).updatetime(new Date()).build());
//
//        Product product = productBusiness.create(Product.builder().createtime(new Date()).price(10.9).updatetime(new Date()).build());
//
//        Order order = orderClient.create(Order.builder().createtime(new Date()).status(1).updatetime(new Date()).build());
//
//
//
////        order.setProducts(Lists.newArrayList(product));
//        product.setOrders(Lists.newArrayList(order));
//        user.setOrders(Lists.newArrayList(order));
//
////        productBusiness.update(product);
////        orderClient.update(order);
//        userClient.update(user);
        return properties.getMessage() + "::::" + UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
        return productBusiness.create(product);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Product update(@RequestBody Product product){
        return productBusiness.update(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable("id") String id){
        Product product = productBusiness.findById(id);
        return productBusiness.update(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        productBusiness.deleteById(id);
        return ResponseEntity.ok().body("SUCCESS");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> list(){
        return productBusiness.findAll();
    }

}
