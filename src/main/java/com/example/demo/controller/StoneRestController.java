package com.example.demo.controller;

import com.example.demo.business.StoneBusiness;
import com.example.demo.entity.Stone;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class StoneRestController {

    @Resource
    private StoneBusiness business;

    @RequestMapping(value = "msg", method = RequestMethod.GET)
    public String msg() {
        return UUID.randomUUID().toString();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Stone create() {
        return business.create();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Stone update(@PathVariable("id") String id) {
        System.out.println(id);
        Stone entity = business.findOneById(id).get();
        entity.setUsername("Fred");
        entity.setFlag(100);
        return business.update(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        try {
            business.findOneById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
           return ResponseEntity.notFound().build();
        }
        business.deleteById(id);
        return ResponseEntity.ok().body("SUCCESS");
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Stone> list() {
        return (List<Stone>) business.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Stone findOne(@PathVariable("id") String id){
        return business.findOneById(id).get();
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll(){
        business.deleteAll();
        return ResponseEntity.ok().body("SUCCESS");
    }
}
