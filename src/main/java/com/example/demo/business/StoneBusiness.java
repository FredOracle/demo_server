package com.example.demo.business;

import com.example.demo.entity.Stone;

import java.util.List;
import java.util.Optional;

public interface StoneBusiness {

    public Stone create();

    public Stone update(Stone entity);

    public void deleteById(String id);

    public Optional<Stone> findOneById(String id);

    public Iterable<Stone> findAll();

    public List<Stone> findAllByFlag(Integer flag);

    public void deleteAll();

}
