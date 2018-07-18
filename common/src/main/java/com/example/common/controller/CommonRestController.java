package com.example.common.controller;

import com.example.common.config.ConfigProperties;
import com.example.common.config.ProductConfigProperties;
import com.example.common.config.UserConfigProperties;
import com.example.common.entity.Demo;
import com.example.common.repository.DemoRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/common")
@Slf4j
public class CommonRestController {

    @Resource
    private ConfigProperties properties;

    @Resource
    private UserConfigProperties userConfigProperties;

    @Resource
    private ProductConfigProperties productConfigProperties;

    @Resource
    private AmqpTemplate template;

    @Resource
    private DemoRepository demoRepository;

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg(){

        log.info("Call Message..............................");
//        template.convertAndSend("Hello", User.builder().age(100).createtime(new Date()).description("This from Controller").name("Fred").password(UUID.randomUUID().toString()).build());

        return  properties.getWelcome() + ":::::" + UUID.randomUUID().toString() +":::::::::::::"+ userConfigProperties.getMessage() + "::::" + UUID.randomUUID().toString() + "::::::::" + productConfigProperties.getMessage();
    }


    /**
     * 这里可以带参数，参数就是msg方法 中的参数，说明当发生融断时所用参数及要处理的异常
     * @param throwable
     * @return
     */
    public String fallbackMethod(Throwable throwable){

        return "There is an error occur and throw an exception";
    }


    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public Demo create(){
        return demoRepository.save(Demo.builder().username(UUID.randomUUID().toString()).password(UUID.randomUUID().toString()).age(100).build());
    }


    @RequestMapping(value = "/demo/{id}", method = RequestMethod.PUT)
    public Demo update(@PathVariable("id") String id){
        Demo d = demoRepository.findById(id).get();
        d.setAge(500);
        d.setUsername("Fred");
        return demoRepository.save(d);
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id){
        demoRepository.deleteById(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public List<Demo> list(){
        return IteratorUtils.toList(demoRepository.findAll().iterator());
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
    public Optional<Demo> load(@PathVariable("id") String id){
        return demoRepository.findById(id);
    }

}
