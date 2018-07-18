package com.example.demo.business;

import com.example.demo.entity.Stone;
import com.example.demo.repository.StoneRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("stoneBusiness")
@Transactional
public class StoneBusinessImpl implements StoneBusiness {

    @Resource
    private StoneRepository repository;

    @Override
    public Stone create() {
        return repository.save(Stone.builder().username(UUID.randomUUID().toString()).password(UUID.randomUUID().toString()).birthday(new Date()).build());
    }

    @Override
    public Stone update(Stone entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Stone> findOneById(String id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Stone> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Stone> findAllByFlag(Integer flag) {
        return repository.findAllByFlag(flag);
    }

    @Override
    public void deleteAll(){
        repository.deleteAll();
    }
}
