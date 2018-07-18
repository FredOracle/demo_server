package com.example.portal.controller;

import com.example.common.entity.Demo;
import com.example.common.entity.Message;
import com.example.portal.remote.CommonClient;
import org.apache.http.HttpEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class PortalRestController {

    @Resource
    private CommonClient commonClient;

    @Resource
    private AmqpTemplate template;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(){


        Demo demo = commonClient.create();
        Date now = new Date();
        template.convertAndSend("Hello", Message.builder().time(now.toString()).type("Create").content("aaaaaaaaaaaaaaaaaaaaaaaaaaa").toString());


        return ResponseEntity.ok().body("SUCCESS");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") String id){
        commonClient.update(id);
        return ResponseEntity.ok().body("SUCCESS");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        commonClient.delete(id);
        return ResponseEntity.ok().body("SUCCESS");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Demo> find(){
        return commonClient.list();
    }
}
